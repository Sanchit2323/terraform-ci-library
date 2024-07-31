package org.p9

class ArchiveReports {
    static void call(steps) {
        steps.stage('Archive Reports') {
            steps.steps {
                steps.archiveArtifacts artifacts: '**/terraform.tfstate', allowEmptyArchive: true
                steps.archiveArtifacts artifacts: '**/tfplan', allowEmptyArchive: true
            }
        }
    }
}
