package src

class TerraformFmt {
    static void format() {
        stage('Terraform Format') {
            catchError {
                sh 'terraform fmt -check -diff'
            }
        }
    }
}
