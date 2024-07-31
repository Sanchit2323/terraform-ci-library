package src

class TerraformInit {
    static void init(String message) {
        echo "Initializing Terraform: ${message}"
        sh 'terraform init' // Example command
    }
}
