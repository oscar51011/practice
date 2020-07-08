package com.practice.notifyLine.service.adapter;

import com.practice.notifyLine.dto.NotifyResult;
import com.practice.notifyLine.dto.NotifyTokenCheckResult;

public interface NotifyLineAdapter {
	public NotifyResult sendLineNotifyMessage(String message);
	public NotifyTokenCheckResult checkLineNotifyTokenVaild();
}
