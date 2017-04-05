
#### mvn eclipse:eclipse -Dwtpversion=2.0
`mvn eclipse:eclipse -Dwtpversion=2.0`

#### jetty 取消文件映射缓存
解决办法，找到 %repo%/org/eclipse/jetty/jetty-webapp/9.2.8.v20150217/jetty-webapp-9.2.8.v20150217.jar（%repo% 表示你
本地的 maven 仓库的目录，另外，将 9.2.8.v20150217 换成你所使用的版本）。用压缩工具打开它, 找到 jetty-webapp-9.2.8.v2015021
7.jar/org/eclipse/jetty/webapp/webdefault.xml，将 webdefault.xml 文件解压缩一份出来，用文本编辑器打开它，搜索找到
useFileMappedBuffer 配置的行，将 true 改成 false 以禁掉缓存。
<init-param>
<param-name>useFileMappedBufferparam-name>
<param-value>falseparam-value>
<init-param>
先确认 jetty 服务已经停止，将原文件 jetty-webapp-9.2.8.v20150217.jar/org/eclipse/jetty/webapp/webdefault.xml 删除，将刚
才那份修改好的 webdefault.xml 文件重新压缩进去即可。

