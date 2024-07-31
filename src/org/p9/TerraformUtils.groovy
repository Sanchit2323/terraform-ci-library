package org.p9

class TerraformUtils {
    static void terraformInit() {
        catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
            sh 'terraform init'
        }
    }

    static void terraformFormat() {
        catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
            sh 'terraform fmt -check -diff > terraform_fmt_report.txt'
        }
    }

    static void terraformValidate() {
        catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
            sh 'terraform validate > terraform_validate_report.txt'
        }
    }
}
