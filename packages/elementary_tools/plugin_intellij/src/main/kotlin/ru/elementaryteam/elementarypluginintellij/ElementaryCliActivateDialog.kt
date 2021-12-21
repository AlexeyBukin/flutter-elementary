package ru.elementaryteam.elementarypluginintellij

import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.DialogWrapper
import java.awt.GridLayout
import javax.swing.JComponent
import javax.swing.JLabel
import javax.swing.JPanel

/**
 * Dialog that asks to install Elementary Cli
 */
class ElementaryCliActivateDialog(
    private val project: Project?,
) :
    DialogWrapper(project) {

    init {
        title = "Activate elementary_cli package?"
        init()
    }

    override fun createCenterPanel(): JComponent {
        val dialogPanel = JPanel(GridLayout(0, 1))
        dialogPanel.grabFocus()

        val descriptionLabel = JLabel("Plugin requires elementary_cli dart package to be activated")
        dialogPanel.add(descriptionLabel)
        return dialogPanel
    }
}