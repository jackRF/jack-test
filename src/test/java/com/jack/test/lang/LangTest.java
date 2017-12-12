package com.jack.test.lang;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Clock;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.junit.Test;

import com.jack.test.BaseTest;
import com.jack.test.lang.Defaulable.DefaultableImpl;
import com.jack.test.lang.Defaulable.OverridableImpl;
import com.jack.test.lang.RepeatingAnnotations.Filter;
import com.jack.test.lang.RepeatingAnnotations.Filterable;
import com.jack.test.lang.Streams.Status;
import com.jack.test.lang.Streams.Task;

public class LangTest extends BaseTest {
	/**
	 * 并行（parallel）数组
	 */
	@Test
	public void testParallelArrays(){
		 long[] arrayOfLong = new long [ 20000 ];        
         
	        Arrays.parallelSetAll( arrayOfLong, 
	            index -> ThreadLocalRandom.current().nextInt( 1000000 ) );
	        Arrays.stream( arrayOfLong ).limit( 10 ).forEach( 
	            i -> log( i + " " ) );
	       log("\n");
	         
	        Arrays.parallelSort( arrayOfLong );     
	        Arrays.stream( arrayOfLong ).limit( 10 ).forEach( 
	            i -> log( i + " " ) );
	        log("\n");
	}
	/**
	 * 测试Base64
	 */
	@Test
	public void testBase64(){
		final String text = "Base64 finally in Java 8!";
        
        final String encoded = Base64
            .getEncoder()
            .encodeToString( text.getBytes( StandardCharsets.UTF_8 ) );
        System.out.println( encoded );
         
        final String decoded = new String( 
            Base64.getDecoder().decode( encoded ),
            StandardCharsets.UTF_8 );
        log( decoded );
        /**
         * Base64类同时还提供了对URL、MIME友好的编码器与解码器
         * （Base64.getUrlEncoder() / Base64.getUrlDecoder()
         * , Base64.getMimeEncoder() / Base64.getMimeDecoder()）。
         */
	}
	/**
	 * JavaScript引擎Nashorn
	 */
	@Test
	public void testScriptEngine(){
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName( "JavaScript" );
		         
		System.out.println( engine.getClass().getName() );
		try {
			log( "Result:" + engine.eval( "function f() { return 1; }; f() + 1;" ) );
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 *  测试Date/Time API
	 */
	@Test
	public void testNewDateTimeAPI() {
		final Clock clock = Clock.systemUTC();
		log( clock.instant() );
		log( clock.millis() );
		
		final LocalDate date = LocalDate.now();
		final LocalDate dateFromClock = LocalDate.now( clock );
		         
		log( date );
		log( dateFromClock );
		         
		// Get the local date and local time
		final LocalTime time = LocalTime.now();
		final LocalTime timeFromClock = LocalTime.now( clock );
		         
		log( time );
		log( timeFromClock );
		
		final LocalDateTime datetime = LocalDateTime.now();
		final LocalDateTime datetimeFromClock = LocalDateTime.now( clock );
		log( datetime );
		log( datetimeFromClock );
		
		final ZonedDateTime zonedDatetime = ZonedDateTime.now();
		final ZonedDateTime zonedDatetimeFromClock = ZonedDateTime.now( clock );
		final ZonedDateTime zonedDatetimeFromZone = ZonedDateTime.now( ZoneId.of( "America/Los_Angeles" ) );
		         
		log( zonedDatetime );
		log( zonedDatetimeFromClock );
		log( zonedDatetimeFromZone );
		
		final LocalDateTime from = LocalDateTime.of( 2014, Month.APRIL, 16, 0, 0, 0 );
		final LocalDateTime to = LocalDateTime.of( 2015, Month.APRIL, 16, 23, 59, 59 );
		 
		final Duration duration = Duration.between( from, to );
		System.out.println( "Duration in days: " + duration.toDays() );
		System.out.println( "Duration in hours: " + duration.toHours() );
	}
	/**
	 * 测试Stream
	 */
	@Test
	public void testStream() {
		final Collection<Task> tasks = Arrays.asList(new Task(Status.OPEN, 5),
				new Task(Status.OPEN, 13), new Task(Status.CLOSED, 8));

		final long totalPointsOfOpenTasks = tasks.stream()
				.filter(task -> task.getStatus() == Status.OPEN)
				.mapToInt(Task::getPoints).sum();

		log("Total points: " + totalPointsOfOpenTasks);

		final double totalPoints = tasks.stream().parallel() // 并行
				.map(task -> task.getPoints()) // or map( Task::getPoints )
				.reduce(0, Integer::sum);

		log("Total points (all tasks): " + totalPoints);
		// 分组
		final Map<Status, List<Task>> map = tasks.stream().collect(
				Collectors.groupingBy(Task::getStatus));
		log(map);
		
		
		// Calculate the weight of each tasks (as percent of total points) 
		final Collection< String > result = tasks
		    .stream()                                        // Stream< String >
		    .mapToInt( Task::getPoints )                     // IntStream
		    .asLongStream()                                  // LongStream
		    .mapToDouble( points -> points / totalPoints )   // DoubleStream
		    .boxed()                                         // Stream< Double >
		    .mapToLong( weigth -> ( long )( weigth * 100 ) ) // LongStream
		    .mapToObj( percentage -> percentage + "%" )      // Stream< String> 
		    .collect(Collectors.toList());                 // List< String > 
		log( result );
		
		String filename="d:\\temp\\streamtest.txt";
		final Path path = new File( filename ).toPath();
		try( Stream< String > lines = Files.lines( path, StandardCharsets.UTF_8 ) ) {
		    lines.onClose( () -> System.out.println("Done!") ).forEach( System.out::println );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 测试Optional
	 */
	@Test
	public void testOptional(){
		Optional< String > fullName = Optional.ofNullable( null );
		log( "Full Name is set? " + fullName.isPresent() );        
		log( "Full Name: " + fullName.orElseGet( () -> "[none]" ) ); 
		log( fullName.map( s -> "Hey " + s + "!" ).orElse( "Hey Stranger!" ) );
		log("\n");
		Optional< String > firstName = Optional.of( "Tom" );
		log( "First Name is set? " + firstName.isPresent() );        
		log( "First Name: " + firstName.orElseGet( () -> "[none]" ) ); 
		log( firstName.map( s -> "Hey " + s + "!" ).orElse( "Hey Stranger!" ) );
	}
	public void paramNames(String idCard,String name){
		log(idCard);
		log(name);
	}
	/**
	 * 测试方法的参数名
	 */
	@Test
	public void testParameterName(){
		try {
			Method method=this.getClass().getMethod("paramNames", String.class,String.class);
			for(Parameter parameter:method.getParameters()){
				log("isNamePresent:"+parameter.isNamePresent());
				log(parameter.getName());
			}
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 类型推测机制
	 */
	@Test
	public void testTypeInference(){
		final Value<String> value = new Value<>();
		/**
		 * Value.defaultValue()的参数类型可以被推测出，所以就不必明确给出。
		 * 在Java 7中，相同的例子将不会通过编译，正确的书写方式是 Value.< String >defaultValue()。
		 */
        value.getOrDefault( "22", Value.defaultValue());
	}
	/**
	 * 测试重复注解
	 */
	@Test
	public void testRepeatableAnn() {
		for( Filter filter: Filterable.class.getAnnotationsByType( Filter.class ) ) {
            System.out.println( filter.value() );
        }
	}
	/**
	 * 测试方法引用
	 */
	@Test
	public void testfnRef() {
		//第一种方法引用是构造器引用，它的语法是Class::new，或者更一般的Class< T >::new。请注意构造器没有参数。
		Car car = Car.create( Car::new );
		List< Car > cars = Arrays.asList( car );
		log(cars.size());
		//第二种方法引用是静态方法引用，它的语法是Class::static_method。请注意这个方法接受一个Car类型的参数。
		cars.forEach( Car::collide);
		//第三种方法引用是特定类的任意对象的方法引用，它的语法是Class::method。请注意，这个方法没有参数。
		cars.forEach( Car::repair );
		Car police =Car.create( Car::new );
		//第四种方法引用是特定对象的方法引用，它的语法是instance::method。请注意，这个方法接受一个Car类型的参数。
		cars.forEach( police::follow );
	}
	/**
	 * 测试接口的默认方法和静态方法
	 */
	@Test
	public void testa() {
		Defaulable defaulable = DefaulableFactory.create(DefaultableImpl::new);
		log(defaulable.notRequired());

		defaulable = DefaulableFactory.create(OverridableImpl::new);
		log(defaulable.notRequired());
	}
	
}
