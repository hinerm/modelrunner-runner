
package org.scijava.modelrunner.engine;

import com.google.common.collect.ImmutableList;

import io.bioimage.modelrunner.engine.EngineInfo;

import java.io.File;
import java.util.List;
import java.util.Objects;

import org.scijava.plugin.AbstractRichPlugin;

public abstract class AbstractDLModelRunnerPlugin extends AbstractRichPlugin
	implements DLModelRunnerPlugin
{

	private final String engine;
	private final String pythonVersion;
	private final String javaVersion;
	private final String os;
	private final String arch;
	private final boolean gpu;
	private final boolean cpu;
	private final boolean rosetta;
	private final ImmutableList<String> jars;

	public AbstractDLModelRunnerPlugin(String engine, String pythonVersion,
		String javaVersion, String os, String arch, boolean gpu, boolean cpu,
		boolean rosetta, List<String> jars)
	{
		super();
		// TODO nb: need to match https://github.com/bioimage-io/model-runner-java/blob/64b4f669e85f86e6ae9bd7c803b133b3b885917b/src/main/java/io/bioimage/modelrunner/engine/EngineInfo.java#L125-L150
		this.engine = engine;
		this.pythonVersion = pythonVersion;
		this.javaVersion = javaVersion;
		this.os = os;
		this.arch = arch;
		this.gpu = gpu;
		this.cpu = cpu;
		this.rosetta = rosetta;
		this.jars = ImmutableList.copyOf(jars);
	}

	@Override
	public EngineInfo createEngineInfo() {
//		<DL_framework_name>-<python_version>-<java_api_version>-<os>-<architecture>-<cpu_if_it_runs_in_cpu>-<gpu_if_it_runs_in_gpu>
//		StringJoiner sb = new StringJoiner("-");
//		sb.add(engine);
//		sb.add(pythonVersion);
//		sb.add(javaVersion);
//		// TODO autodetect here?
//		sb.add(os);
//		sb.add(arch);
//		sb.add(String.valueOf(cpu));
//		sb.add(String.valueOf(gpu));
		String userHome = System.getProperty("user.home");
		String jarsDirectory = new File(userHome, ".engines").getAbsolutePath();
		//TODO check if THIS engine info exists and if not download the stuff
		return EngineInfo.defineDLEngine(engine, pythonVersion, jarsDirectory, cpu,
			gpu);
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpu, engine, gpu, jars, os, arch, rosetta,
			pythonVersion, javaVersion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		AbstractDLModelRunnerPlugin other = (AbstractDLModelRunnerPlugin) obj;
		return cpu == other.cpu && Objects.equals(engine, other.engine) &&
			gpu == other.gpu && Objects.equals(jars, other.jars) && Objects.equals(os,
				other.os) && Objects.equals(arch, arch) && rosetta == other.rosetta &&
			Objects.equals(pythonVersion, other.pythonVersion) && Objects.equals(
				javaVersion, other.javaVersion);
	}

	@Override
	public String toString() {
		return "DLModelRunnerPlugin [engine=" + engine + "\n\tpythonVersion=" +
			pythonVersion + "\n\tjavaVersion=" + javaVersion + "\n\tos=" + os +
			"\n\tarch=" + arch + "\n\tgpu=" + gpu + "\n\tcpu=" + cpu +
			"\n\trosetta=" + rosetta + "\n\tjars=" + jars + "]";
	}
}
