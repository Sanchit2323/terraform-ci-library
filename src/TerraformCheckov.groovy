package src

class TerraformCheckov {
    static void scan(String message) {
        echo "Running Checkov scan: ${message}"
        sh 'checkov -d . ' // Example command
    }
}

