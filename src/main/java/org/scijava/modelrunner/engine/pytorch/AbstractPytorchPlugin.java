
package org.scijava.modelrunner.engine.pytorch;

import com.google.common.collect.ImmutableList;

import org.scijava.modelrunner.engine.AbstractDLModelRunnerPlugin;

public abstract class AbstractPytorchPlugin extends
	AbstractDLModelRunnerPlugin
{

	public AbstractPytorchPlugin(String pythonVersion, String javaVersion,
		String os, String arch, boolean gpu, boolean cpu, boolean rosetta,
		ImmutableList<String> jars)
	{
		super("torchscript", pythonVersion, javaVersion, os, arch, gpu, cpu, rosetta,
			jars);
	}
}
