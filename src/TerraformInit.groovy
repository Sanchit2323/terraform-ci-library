package src

class TerraformInit {
    static void init() {
        stage('Terraform Init') {
            catchError {
                sh 'terraform init'
            }
        }
    }
}
