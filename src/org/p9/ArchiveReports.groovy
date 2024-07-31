package org.p9

def call() {
    stage('Archive Reports') {
        steps {
            echo 'Archiving Reports'
            archiveArtifacts artifacts: 'terraform_fmt_report.txt, terraform_validate_report.txt, checkov_report.json, tflint_report.json', allowEmptyArchive: true
        }
    }
}
