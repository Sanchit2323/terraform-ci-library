package src

class TerraformCheckov {
    static void scan() {
        stage('Checkov Scan') {
            catchError {
                sh '''
                    checkov -d . -s --output-file-path checkov_report.json
                '''
            }
        }
    }
}
