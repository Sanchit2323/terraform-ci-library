def call(String stage) {
    switch(stage) {
        case 'init':
            src.TerraformInit.init("Running Terraform Init")
            break
        case 'validate':
            src.TerraformValidate.validate("Running Terraform Validate")
            break
        case 'checkov':
            src.TerraformCheckov.scan("Running Checkov Scan")
            break
        case 'fmt':
            src.TerraformFmt.format("Running Terraform Format Check")
            break
        case 'lint':
            src.TerraformLint.lint("Running Terraform Lint")
            break
        default:
            error("Unknown stage: ${stage}")
    }
}
