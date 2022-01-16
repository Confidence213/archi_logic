sudo apt install openjdk-11-jre-headless maven

cd backend/eventmanager

mvn clean install

# docker pull mariadb
# docker run --detach --name mariadb --env MARIADB_USER=pifou --env MARIADB_PASSWORD=pasglop --env MARIADB_ROOT_PASSWORD=glopglop --env MARIADB_DATABASE=db -p 3306:3306 mariadb:latest

# docker build -t app-image .
# docker run -d --name app-name -p 8080:8080 app-image

cd ../..

docker-compose up -d