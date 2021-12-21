package ru.elementaryteam.elementarypluginintellij

import com.intellij.execution.process.ProcessAdapter
import com.intellij.execution.process.ProcessEvent
import com.intellij.openapi.actionSystem.DataContext
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Key
import io.flutter.FlutterMessages
import io.flutter.actions.FlutterSdkAction
import io.flutter.pub.PubRoot
import io.flutter.sdk.FlutterSdk
import ru.elementaryteam.elementarypluginintellij.ActivateCliConstants.CANNOT_ACTIVATE
import ru.elementaryteam.elementarypluginintellij.ActivateCliConstants.CANNOT_LIST_PUB_PACKAGES
import java.util.concurrent.CompletableFuture
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

/**
 * Some helpful constants
 */

object ActivateCliConstants {
    const val ACTIVATE_ACTION_ID = "Elementary.Invisible.ActivateCli"
    const val CANNOT_LIST_PUB_PACKAGES = "Cannot list pub packages"
    const val CANNOT_ACTIVATE = "Cannot activate elementary_cli package"
}

/**
 * Action that lets to generate new elementary module
 */
class ElementaryCliActivateAction : FlutterSdkAction() {

    var future = CompletableFuture<Boolean>()

    override fun startCommand(
        project: Project,
        sdk: FlutterSdk,
        root: PubRoot?,
        context: DataContext
    ) {
        checkIfActivatedJava(
            project,
            sdk,
            root
        ) { isActivated: Boolean ->
            FlutterMessages.showInfo("Checking package...", "status: $isActivated", project)
        }

//        FlutterMessages.showInfo("Checking package...", "status: bruh", project)
//        CoroutineScope(Job() + Dispatchers.IO)
////        GlobalScope.launch(CoroutineScope(Job() + Dispatchers.IO)) {
////             ...
////        }
//        FlutterMessages.showInfo("Checking package...", "status: bruh 2", project)
//        runBlocking {
////            val isActivated = checkIfActivated(
////                project,
////                sdk,
////                root
////            )
//            FlutterMessages.showInfo("Checking package...", "status: bruh", project)
//            FlutterMessages.showInfo("Checking package...", "status: $isActivated", project)
//            if (!isActivated) {
//                val dialog = ElementaryCliActivateDialog(project)
//                if (dialog.showAndGet()) {
//                    val status = activate(
//                        project,
//                        sdk,
//                        root
//                    )
//                    FlutterMessages.showInfo("Activating package...", "status: $status", project)
//                }
//            }
//        }
//        future.complete(true)
    }

    private fun checkIfActivatedJava(
        project: Project,
        sdk: FlutterSdk,
        root: PubRoot?,
        onComplete: (Boolean) -> Unit
    ) {

        val pubListArguments = arrayOf(
            "global",
            "list"
        )

        val listProcessHandler = sdk.flutterPub(root, *pubListArguments).startInConsole(project)
            ?: throw Throwable(message = CANNOT_LIST_PUB_PACKAGES)

        listProcessHandler.addProcessListener(object : ProcessAdapter() {
//            override fun processTerminated(event: ProcessEvent) {
//                if (event.exitCode != 0) {
//                   throw Throwable(message = CANNOT_LIST_PUB_PACKAGES)
//                }
//                onComplete(event.text.matches(Regex("^elementary_cli")))
//            }

            override fun onTextAvailable(
                event: ProcessEvent,
                outputType: Key<*>
            ) {
                FlutterMessages.showInfo("Text", "bruh: ${event.text}", project)
//                if (event.exitCode != 0) {
//                    throw Throwable(message = CANNOT_LIST_PUB_PACKAGES)
//                }
                onComplete(event.text.matches(Regex("^elementary_cli")))
            }
        })
    }

    private suspend fun activate(
        project: Project,
        sdk: FlutterSdk,
        root: PubRoot?
    ): Int {
        val pubActivateArguments = arrayOf(
            "global",
            "activate",
            "elementary_cli"
        )

        val listProcessHandler = sdk.flutterPub(root, *pubActivateArguments).startInConsole(project)
            ?: throw Throwable(message = CANNOT_ACTIVATE)

        val status = suspendCoroutine<Int> { continuation ->
            listProcessHandler.addProcessListener(object : ProcessAdapter() {
                override fun processTerminated(event: ProcessEvent) {
                    continuation.resume(event.exitCode)
                }
            })
        }

        return status
    }


//    private suspend fun checkIfActivated(
//        project: Project,
//        sdk: FlutterSdk,
//        root: PubRoot?
//    ): Boolean {
//
//        val pubListArguments = arrayOf(
//            "global",
//            "list"
//        )
//
//        val listProcessHandler = sdk.flutterPub(root, *pubListArguments).startInConsole(project)
//            ?: throw Throwable(message = CANNOT_LIST_PUB_PACKAGES)
//
//        val text = suspendCoroutine<String> { continuation ->
//            listProcessHandler.addProcessListener(object : ProcessAdapter() {
//                override fun processTerminated(event: ProcessEvent) {
//                    if (event.exitCode != 0) {
//                        continuation.resumeWithException(Throwable(message = CANNOT_LIST_PUB_PACKAGES))
//                    }
//                    continuation.resume(event.text)
//                }
//            })
//        }
//
//        // TODO check that multiline works
//        return text.matches(Regex("^elementary_cli"))
//    }
}


