podTemplate(label: 'java',
        containers: [
                containerTemplate(name: 'jdk', image: 'openjdk:8-jdk', ttyEnabled: true, command: 'cat')
        ]) {
    node("java"){
        checkout scm
        container("jdk") {
            stage('Test') {
                sh '''wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb;
                      sudo dpkg -i google-chrome-stable_current_amd64.deb;
                      ./gradlew test
                   '''    
            }
        }
    }
}
