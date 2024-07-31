package org.p9

class CheckovUtils {
    static void runCheckov() {
        catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
            sh """
                cd ${env.WORKSPACE}
                /var/lib/jenkins/.local/bin/checkov -d . -s --output-file-path checkov_report.json
            """
            sh 'ls -l'
        }
    }
}
