def call(String repoUrl){
  pipeline {
       agent any
       tools {
           maven 'maven'
       }
       stages {
           stage("Tools initialization") {
               steps {
                   sh 'mvn --version'
                   sh 'java -version'
               }
           }
           stage("Checkout Code") {
               steps {
                   git branch: 'main',
                          url: "${repoUrl}"
               }
           }
           stage('sub-job3'){
				steps{
				  echo 'action3'
               }
           }
       }
   }
}
