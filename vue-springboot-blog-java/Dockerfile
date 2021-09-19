FROM centos:7
RUN yum -y update \
    && yum -y install vim \
    && yum -y install git \
    && yum -y install java-1.8.0-openjdk-devel.x86_64 \
    && yum install -y maven \
    && mkdir ~/.m2
RUN echo '<?xml version="1.0" encoding="UTF-8"?><settings xmlns="http://maven.apache.org/SETTINGS/1.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd"><mirrors><mirror><id>alimaven</id><mirrorOf>central</mirrorOf><name>aliyun maven</name><url>http://maven.aliyun.com/nexus/content/repositories/central/</url></mirror></mirrors></settings>' > ~/.m2/settings.xml
