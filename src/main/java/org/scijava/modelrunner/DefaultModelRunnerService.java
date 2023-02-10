package org.scijava.modelrunner;

import java.util.List;

import org.scijava.modelrunner.engine.DLModelRunnerPlugin;
import org.scijava.plugin.Parameter;
import org.scijava.plugin.Plugin;
import org.scijava.plugin.PluginService;
import org.scijava.service.AbstractService;
import org.scijava.service.Service;

@Plugin(type = Service.class)
public class DefaultModelRunnerService extends AbstractService implements
	ModelRunnerService
{

	@Parameter
	private PluginService pluginService;

	@Override
	public List<DLModelRunnerPlugin> getEngines() {
		return pluginService.createInstancesOfType(DLModelRunnerPlugin.class);
	}
}
