package src

class TerraformValidate {
    static void validate() {
        stage('Terraform Validate') {
            catchError {
                sh 'terraform validate'
            }
        }
    }
}
