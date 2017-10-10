package com.emc.mongoose.storage.driver.nfs;

import com.emc.mongoose.api.common.exception.OmgShootMyFootException;
import com.emc.mongoose.api.model.data.DataInput;
import com.emc.mongoose.api.model.io.task.data.DataIoTask;
import com.emc.mongoose.api.model.item.DataItem;
import com.emc.mongoose.storage.driver.base.StorageDriverFactory;
import com.emc.mongoose.ui.config.load.LoadConfig;
import com.emc.mongoose.ui.config.storage.StorageConfig;

public class NfsStorageDriverFactory<
	I extends DataItem, O extends DataIoTask<I>, T extends NfsStorageDriver<I, O>
>
implements StorageDriverFactory<I, O, T> {

	private static final String NAME = "nfs";

	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public T create(
		final String stepId, final DataInput dat, final LoadConfig loadConfig,
		final StorageConfig storageConfig, final boolean verifyFlag
	) throws OmgShootMyFootException, InterruptedException {
		return (T) new NfsStorageDriver<>(
			stepId, dat, loadConfig, storageConfig, verifyFlag
		);
	}
}
