read -p "请输入您要发布的分支名,例如develop  " branch
if [ n "$branch"]; then
  branch="master"
fi
echo "关闭tomcat"
sh /usr/local/tomcat/bin/shutdown.sh
fuser -k 8080/tcp
fuser -k 8009/tcp
#echo "备份原文件"


echo "更新代码"	
cd ~/project/credit-zx/
git fetch
git checkout $branch
git pull origin $branch
echo "开始编译creditzx"
mvn -Dmaven.test.skip=true clean package -U

# 查找war包
WARFILE=$(find /root/project/credit-zx/creditzx-web/target -name "*.war" | xargs awk 'END{ var=FILENAME; n=split (var,a,/\//); print a[n]}')

echo "开始部署"
echo "替换war包，删除creditzx-web/*"
rm -rf /usr/local/tomcat/webapps/creditzx-web/*
cp ~/project/credit-zx/creditzx-web/target/$WARFILE /usr/local/tomcat/webapps/creditzx-web/
cd /usr/local/tomcat/webapps/creditzx-web/
echo "解压$WARFILE"
jar -xf $WARFILE 
rm /usr/local/tomcat/webapps/creditzx-web/$WARFILE 

cd ~
echo "启动tomcat服务器"
sh /usr/local/tomcat/bin/startup.sh
echo "tomcat服务器启动成功，输出logs"
tail -f /usr/local/tomcat/logs/catalina.out
