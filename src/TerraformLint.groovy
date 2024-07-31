package src

class TerraformLint {
    static void lint(String message) {
        echo "Linting Terraform: ${message}"
        sh 'tflint' // Example command for linting
    }
}
