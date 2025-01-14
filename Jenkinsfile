def workspace;
node{
    stage('Checkout'){
        checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: 'git token', url: 'https://github.com/AditiNarlawar/ShoppingUITests']])
        wprksapce = pwd()
    }
    stage('Static code analysis'){
        echo "Static code analysis"
    }
     stage('Build'){
        echo "Build code"
    }
     stage('Unit testing'){
        echo "Testing code"
    }
     stage('Delivery'){
        echo "Deliver the code"
    }
}
