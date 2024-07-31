package src

class TerraformValidate {
    static void validate(String message) {
        echo "Validating Terraform: ${message}"
        sh 'terraform validate' // Example command
    }
}

