package src

class TerraformFmt {
    static void format(String message) {
        echo "Formatting Terraform: ${message}"
        sh 'terraform fmt -check' // Example command to check formatting
    }
}

