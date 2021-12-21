package ru.elementaryteam.elementarypluginintellij

import com.intellij.execution.process.ProcessAdapter
import com.intellij.execution.process.ProcessEvent
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Key
import io.flutter.FlutterMessages
import io.flutter.pub.PubRoot
import io.flutter.sdk.FlutterSdk
import ru.elementaryteam.elementarypluginintellij.ActivateCliConstants.CANNOT_LIST_PUB_PACKAGES
import java.util.concurrent.CompletableFuture

/**
 * Action that lets to generate new elementary module
 */
class ElementaryCliActivateChecker {

    var future = CompletableFuture<Boolean>()

    fun check(
        project: Project,
        sdk: FlutterSdk,
        root: PubRoot?,
    ): CompletableFuture<Boolean> {

        CompletableFuture.runAsync {  }
        val pubListArguments = arrayOf(
            "global",
            "list"
        )

        val listProcessHandler = sdk.flutterPub(root, *pubListArguments).startInConsole(project)
            ?: throw Throwable(message = CANNOT_LIST_PUB_PACKAGES)

        listProcessHandler.addProcessListener(object : ProcessAdapter() {
            override fun onTextAvailable(
                event: ProcessEvent,
                outputType: Key<*>
            ) {
                FlutterMessages.showInfo("Text", "bruh: ${event.text}", project)
                future.complete(event.text.matches(Regex("^elementary_cli")))
            }
        })

        return future
    }

//    private fun activate(
//        project: Project,
//        sdk: FlutterSdk,
//        root: PubRoot?
//    ): Int {
//        val pubActivateArguments = arrayOf(
//            "global",
//            "activate",
//            "elementary_cli"
//        )
//
//        val listProcessHandler = sdk.flutterPub(root, *pubActivateArguments).startInConsole(project)
//            ?: throw Throwable(message = ActivateCliConstants.CANNOT_ACTIVATE)
//
//        val status = suspendCoroutine<Int> { continuation ->
//            listProcessHandler.addProcessListener(object : ProcessAdapter() {
//                override fun processTerminated(event: ProcessEvent) {
//                    continuation.resume(event.exitCode)
//                }
//            })
//        }
//
//        return status
//    }
}


