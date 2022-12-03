pipeline {
agent any
       stages{
        stage('Clone'){
             steps{  
                 git branch: 'Emna', url: 'https://github.com/EmnaFerchichi/DevopsRepos.git'
             }
        }
       
        stage('MVN CLEAN') {
            steps {
                sh 'mvn clean'
                 
            }
        }
           stage("Build") {
                 steps {
sh "mvn compile"
}}

stage("Unit tests") {
steps {
sh "mvn test"
}}

stage('MVN SONARQUBE') {
            steps {
           sh "mvn sonar:sonar \
  -Dsonar.projectKey=sonarqubedevops \
  -Dsonar.host.url=http://192.168.56.2:9000 \
  -Dsonar.login=18916fd505cb784e6c98b8cfefc603ce8f0823d2"
                 
            }
        }
        
        
	       stage('Clean Package') {
            
            steps {
                sh 'mvn clean package'  
            }
     
            } 
        
         stage("DEPLOY With Nexus") {
            steps { 
                sh'mvn clean deploy -Dmaven.test.skip=true -Dresume=false'
            }
        }
        
        stage('Build image') {
           	steps {
       		 sh "docker build -t emnaferchichi/devopsproject ."
       		}
       		}   
       		
       		
       		 stage("login DockerHub") {
                steps{
                    sh 'echo download999!! | docker login -u emnaferchichi -p download99'
                }
        }
        
        stage("Push to DockerHub") {
                steps{
                    sh 'docker push emnaferchichi/devopsproject'
                }
        }
                    
      stage("Docker-compose") {
                steps{
                    sh 'docker-compose up -d'
                }
        } 
        
        
        



   }
}
