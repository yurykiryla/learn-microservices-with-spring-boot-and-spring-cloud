echo "********************************************************"
echo "Starting zipkinserver service "
echo "********************************************************"
java -Djava.security.egd=file:/dev./urandom -jar /usr/local/zipkinserver/@project.build.finalName@.jar