#!/bin/sh

# 复制项目的文件到对应docker路径，便于一键生成镜像。
usage() {
	echo "Usage: sh copy.sh"
	exit 1
}


# copy sql
echo "begin copy sql "
cp ../sql/ry_20210908.sql ./mysql/db
cp ../sql/ry_config_20220114.sql ./mysql/db

# copy html
echo "begin copy html "
cp -r ../exam-ui/dist/** ./nginx/html/dist


# copy jar
echo "begin copy exam-gateway "
cp ../exam-gateway/target/exam-gateway.jar ./exam/gateway/jar

echo "begin copy exam-auth "
cp ../exam-auth/target/exam-auth.jar .//auth/jar

echo "begin copy exam-visual "
cp ../exam-visual/exam-monitor/target/exam-visual-monitor.jar  ./exam/visual/monitor/jar

echo "begin copy exam-modules-system "
cp ../exam-modules/exam-system/target/exam-modules-system.jar ./exam/modules/system/jar

echo "begin copy exam-modules-file "
cp ../exam-modules/exam-file/target/exam-modules-file.jar ./exam/modules/file/jar

echo "begin copy exam-modules-job "
cp ../exam-modules/exam-job/target/exam-modules-job.jar ./exam/modules/job/jar

echo "begin copy exam-modules-gen "
cp ../exam-modules/exam-gen/target/exam-modules-gen.jar ./exam/modules/gen/jar

