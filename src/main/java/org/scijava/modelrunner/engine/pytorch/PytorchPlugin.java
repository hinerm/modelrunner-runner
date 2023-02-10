
package org.scijava.modelrunner.engine.pytorch;

import com.google.common.collect.ImmutableList;

import org.scijava.modelrunner.engine.DLModelRunnerPlugin;
import org.scijava.plugin.Plugin;

@Plugin(type = DLModelRunnerPlugin.class)
public class PytorchPlugin extends AbstractPytorchPlugin {

	public PytorchPlugin() {
		super("1.13.0", "1.13.0", "windows", "x86-64", true, true, true,
			ImmutableList.of(
				"https://repo1.maven.org/maven2/ai/djl/pytorch/pytorch-jni/1.13.0-0.20.0/pytorch-jni-1.13.0-0.20.0.jar",
				"https://repo1.maven.org/maven2/ai/djl/pytorch/pytorch-engine/0.20.0/pytorch-engine-0.20.0.jar",
				"https://repo1.maven.org/maven2/ai/djl/api/0.20.0/api-0.20.0.jar",
				"https://repo1.maven.org/maven2/org/slf4j/slf4j-simple/1.7.25/slf4j-simple-1.7.25.jar",
				"https://maven.scijava.org/content/repositories/releases/io/bioimage/dl-modelrunner-pytorch/0.1.0/dl-modelrunner-pytorch-0.1.0.jar",
				"https://repo1.maven.org/maven2/net/java/dev/jna/jna/5.13.0/jna-5.13.0.jar",
				"https://repo1.maven.org/maven2/org/apache/commons/commons-compress/1.21/commons-compress-1.21.jar",
				"https://repo1.maven.org/maven2/org/slf4j/slf4j-api/2.0.6/slf4j-api-2.0.6.jar"));
	}
}
