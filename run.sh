#!/bin/bash
echo "脚本需要管理员密码来获取可执行权限,若已获得请忽略!"
sudo chmod a+x run.sh
cd src
# javac Gamewin.java
# javac Common.java
# javac EnemyFish.java
# javac MyFish.java
# javac StartGame.java
java StartGame
cd ..