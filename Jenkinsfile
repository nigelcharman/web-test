podTemplate(label: 'java',
        containers: [
                containerTemplate(name: 'jdk', image: 'openjdk:8-jdk', ttyEnabled: true, command: 'cat')
        ]) {
    node("java"){
        checkout scm
        container("jdk") {
            stage('Test') {
                sh '''wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | sudo apt-key add -;
                      sh -c 'echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google.list';
                      apt update;
                      apt install google-chrome-stable;
                      ./gradlew test
                   '''    
            }
        }
    }
}
