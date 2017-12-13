package com.jack.test.thread;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.security.AccessControlException;
import java.util.Random;

public class Awaiting {
	private int port;
	private String address = "localhost";
	private String shutdown = "SHUTDOWN";
	private volatile Thread awaitThread = null;
	private volatile ServerSocket awaitSocket = null;
	private volatile boolean stopAwait = false;
	private  Random random;
	public Awaiting(int port){
		this.port=port;
	}
	public Awaiting(int port,String address,String shutdown){
		this.port=port;
		this.address=address;
		this.shutdown=shutdown;
	}
	public void stopAwait() {
        stopAwait=true;
        Thread t = awaitThread;
        if (t != null) {
            ServerSocket s = awaitSocket;
            if (s != null) {
                awaitSocket = null;
                try {
                    s.close();
                } catch (IOException e) {
                    // Ignored
                }
            }
            t.interrupt();
            try {
                t.join(1000);
            } catch (InterruptedException e) {
                // Ignored
            }
        }
    }
	public void await() {
		if (port == -2) {
			return;
		}
		if (port == -1) {
			try {
				awaitThread = Thread.currentThread();
				while (!stopAwait) {
					try {
						Thread.sleep(10000);
					} catch (InterruptedException ex) {
					}
				}
			} finally {
				awaitThread = null;
			}
			return;
		}
		// Set up a server socket to wait on
        try {
            awaitSocket = new ServerSocket(port, 1,
                    InetAddress.getByName(address));
        } catch (IOException e) {
//            log.error("StandardServer.await: create[" + address
//                               + ":" + port
//                               + "]: ", e);
            return;
        }
		try {
			awaitThread = Thread.currentThread();

			// Loop waiting for a connection and a valid command
			while (!stopAwait) {
				ServerSocket serverSocket = awaitSocket;
				if (serverSocket == null) {
					break;
				}

				// Wait for the next connection
				Socket socket = null;
				StringBuilder command = new StringBuilder();
				try {
					InputStream stream;
					long acceptStartTime = System.currentTimeMillis();
					try {
						socket = serverSocket.accept();
						socket.setSoTimeout(10 * 1000); // Ten seconds
						stream = socket.getInputStream();
					} catch (SocketTimeoutException ste) {
						// This should never happen but bug 56684 suggests that
						// it does.
						// log.warn(sm.getString("standardServer.accept.timeout",
						// Long.valueOf(System.currentTimeMillis() -
						// acceptStartTime)), ste);
						continue;
					} catch (AccessControlException ace) {
						// log.warn("StandardServer.accept security exception: "
						// + ace.getMessage(), ace);
						continue;
					} catch (IOException e) {
						if (stopAwait) {
							// Wait was aborted with socket.close()
							break;
						}
						// log.error("StandardServer.await: accept: ", e);
						break;
					}

					// Read a set of characters from the socket
					int expected = 1024; // Cut off to avoid DoS attack
					while (expected < shutdown.length()) {
						if (random == null)
							random = new Random();
						expected += (random.nextInt() % 1024);
					}
					while (expected > 0) {
						int ch = -1;
						try {
							ch = stream.read();
						} catch (IOException e) {
							// log.warn("StandardServer.await: read: ", e);
							ch = -1;
						}
						// Control character or EOF (-1) terminates loop
						if (ch < 32 || ch == 127) {
							break;
						}
						command.append((char) ch);
						expected--;
					}
				} finally {
					// Close the socket now that we are done with it
					try {
						if (socket != null) {
							socket.close();
						}
					} catch (IOException e) {
						// Ignore
					}
				}

				// Match against our command string
				boolean match = command.toString().equals(shutdown);
				if (match) {
					// log.info(sm.getString("standardServer.shutdownViaPort"));
					break;
				} else {
					// log.warn("StandardServer.await: Invalid command '"
					// + command.toString() + "' received");
				}
			}
		} finally {
			ServerSocket serverSocket = awaitSocket;
			awaitThread = null;
			awaitSocket = null;

			// Close the server socket and return
			if (serverSocket != null) {
				try {
					serverSocket.close();
				} catch (IOException e) {
					// Ignore
				}
			}
		}
	}
}
