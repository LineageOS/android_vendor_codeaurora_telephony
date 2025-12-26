/* Copyright (c) 2015-2017, 2019-2021 The Linux Foundation. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 *       copyright notice, this list of conditions and the following
 *       disclaimer in the documentation and/or other materials provided
 *       with the distribution.
 *     * Neither the name of The Linux Foundation nor the names of its
 *       contributors may be used to endorse or promote products derived
 *       from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED "AS IS" AND ANY EXPRESS OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT
 * ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS
 * BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR
 * BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
 * OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN
 * IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * Changes from Qualcomm Innovation Center are provided under the following license:
 * Copyright (c) 2023-2025 Qualcomm Innovation Center, Inc. All rights reserved.
 * SPDX-License-Identifier: BSD-3-Clause-Clear.
 */

package org.codeaurora.ims;

import org.codeaurora.ims.internal.IQtiImsExtListener;
import android.telephony.ims.ImsCallForwardInfo;
import android.os.RemoteException;
import java.util.concurrent.Executor;
import org.codeaurora.ims.utils.QtiImsExtUtils;

/**
 * This class contains default implementation for IQtiImsExtListener.
 */
public abstract class QtiImsExtListenerBaseImpl {

   private final class QtiImsExtListenerBinder extends IQtiImsExtListener.Stub {
        @Override
        public void onSetCallForwardUncondTimer(int phoneId, int status) throws RemoteException {
            QtiImsExtUtils.executeMethodAsync(() ->
                    QtiImsExtListenerBaseImpl.this.onSetCallForwardUncondTimer(phoneId, status),
                    "onSetCallForwardUncondTimer", mExecutor);
        }

        @Override
        public void onGetCallForwardUncondTimer(int phoneId, int startHour, int endHour,
                int startMinute, int endMinute, int reason, int status, String number, int service)
             throws RemoteException {
            QtiImsExtUtils.executeMethodAsync(() ->
                    QtiImsExtListenerBaseImpl.this.onGetCallForwardUncondTimer(phoneId, startHour,
                    endHour, startMinute, endMinute, reason, status, number, service),
                    "onGetCallForwardUncondTimer", mExecutor);
        }

        @Override
        public void onUTReqFailed(int phoneId, int errCode, String errString)
             throws RemoteException {
            QtiImsExtUtils.executeMethodAsync(() ->
                    QtiImsExtListenerBaseImpl.this.onUTReqFailed(phoneId, errCode, errString),
                    "onUTReqFailed", mExecutor);
        }

        @Override
        public void receiveCancelModifyCallResponse(int phoneId, int result)
             throws RemoteException {
            QtiImsExtUtils.executeMethodAsync(() ->
                    QtiImsExtListenerBaseImpl.this.receiveCancelModifyCallResponse(phoneId, result),
                    "receiveCancelModifyCallResponse", mExecutor);
        }

        @Override
        public void notifyVopsStatus(int phoneId, boolean vopsStatus) throws RemoteException {
             QtiImsExtUtils.executeMethodAsync(() ->
                    QtiImsExtListenerBaseImpl.this.notifyVopsStatus(phoneId, vopsStatus),
                    "notifyVopsStatus", mExecutor);
        }

        @Override
        public void notifySsacStatus(int phoneId, boolean ssacStatusResponse)
             throws RemoteException {
            QtiImsExtUtils.executeMethodAsync(() ->
                    QtiImsExtListenerBaseImpl.this.notifySsacStatus(phoneId, ssacStatusResponse),
                    "notifySsacStatus", mExecutor);
        }

        @Override
        public void notifyParticipantStatusInfo(int phoneId, int operation, int sipStatus,
                String participantUri, boolean isEct) throws RemoteException {
            QtiImsExtUtils.executeMethodAsync(() ->
                    QtiImsExtListenerBaseImpl.this.notifyParticipantStatusInfo(phoneId, operation,
                    sipStatus, participantUri, isEct),
                    "notifyParticipantStatusInfo", mExecutor);
        }

        @Override
        public void onVoltePreferenceUpdated(int phoneId, int result)
             throws RemoteException {
            QtiImsExtUtils.executeMethodAsync(() ->
                    QtiImsExtListenerBaseImpl.this.onVoltePreferenceUpdated(phoneId, result),
                    "onVoltePreferenceUpdated", mExecutor);
        }

        @Override
        public void onVoltePreferenceQueried(int phoneId, int result, int mode)
             throws RemoteException {
            QtiImsExtUtils.executeMethodAsync(() ->
                    QtiImsExtListenerBaseImpl.this.onVoltePreferenceQueried(phoneId, result, mode),
                    "onVoltePreferenceQueried", mExecutor);
        }

        @Override
        public void onSetHandoverConfig(int phoneId, int result)
             throws RemoteException {
            QtiImsExtUtils.executeMethodAsync(() ->
                    QtiImsExtListenerBaseImpl.this.onSetHandoverConfig(phoneId, result),
                    "onSetHandoverConfig", mExecutor);
        }

        @Override
        public void onGetHandoverConfig(int phoneId, int result, int hoConfig)
             throws RemoteException {
            QtiImsExtUtils.executeMethodAsync(() ->
                    QtiImsExtListenerBaseImpl.this.onGetHandoverConfig(phoneId, result, hoConfig),
                    "onGetHandoverConfig", mExecutor);
        }

        @Override
        public void onUssdFailed(int phoneId, int type, int errorCode,
                String errorMessage) throws RemoteException {
            QtiImsExtUtils.executeMethodAsync(() ->
                    QtiImsExtListenerBaseImpl.this.onUssdFailed(phoneId, type, errorCode,
                    errorMessage),
                    "onUssdFailed", mExecutor);
        }

        @Override
        public void queryCallForwardStatusResponse(int phoneId, ImsCallForwardInfo[] cfInfoList)
             throws RemoteException {
            QtiImsExtUtils.executeMethodAsync(() ->
                    QtiImsExtListenerBaseImpl.this.queryCallForwardStatusResponse(phoneId,
                    cfInfoList),
                    "queryCallForwardStatusResponse", mExecutor);
        }

        @Override
        public void queryCallBarringResponse(int[] response) throws RemoteException {
            QtiImsExtUtils.executeMethodAsync(() ->
                    QtiImsExtListenerBaseImpl.this.queryCallBarringResponse(response),
                    "queryCallBarringResponse", mExecutor);
        }

        @Override
        public void onScbmExited(boolean status) throws RemoteException {
            QtiImsExtUtils.executeMethodAsync(() ->
                    QtiImsExtListenerBaseImpl.this.onScbmExited(status),
                    "onScbmExited", mExecutor);
        }

        @Override
        public void notifyDataChannelCapability(int phoneId, boolean dcCapability)
             throws RemoteException {
            QtiImsExtUtils.executeMethodAsync(() ->
                    QtiImsExtListenerBaseImpl.this.notifyDataChannelCapability(phoneId,
                    dcCapability), "notifyDataChannelCapability", mExecutor);
        }

        @Override
        public void handleSendVosSupportStatusResponse(int phoneId, int result)
             throws RemoteException {
            QtiImsExtUtils.executeMethodAsync(() ->
                    QtiImsExtListenerBaseImpl.this.handleSendVosSupportStatusResponse(phoneId,
                    result), "handleSendVosSupportStatusResponse", mExecutor);
        }

        @Override
        public void handleSendVosActionInfoResponse(int phoneId, int result)
             throws RemoteException {
            QtiImsExtUtils.executeMethodAsync(() ->
                    QtiImsExtListenerBaseImpl.this.handleSendVosActionInfoResponse(phoneId,
                    result), "handleSendVosActionInfoResponse", mExecutor);
        }

        @Override
        public void onSetGlassesFree3dVideoCapabilityResponse(int phoneId, int result)
             throws RemoteException {
            QtiImsExtUtils.executeMethodAsync(() ->
                    QtiImsExtListenerBaseImpl.this.
                    onSetGlassesFree3dVideoCapabilityResponse(phoneId, result),
                    "onSetGlassesFree3dVideoCapabilityResponse", mExecutor);
        }

        @Override
        public void onIncomingRttVtUpgrade()
             throws RemoteException {
            QtiImsExtUtils.executeMethodAsync(() ->
                    QtiImsExtListenerBaseImpl.this.
                    onIncomingRttVtUpgrade(),
                    "onIncomingRttVtUpgrade", mExecutor);
        }
   };

    private Executor mExecutor;
    private QtiImsExtListenerBinder mListener;

    public QtiImsExtListenerBaseImpl() {
       mExecutor = Runnable::run;
    }

    public QtiImsExtListenerBaseImpl(Executor executor) {
        mExecutor = executor;
    }

    QtiImsExtListenerBinder getBinder() {
        if (mListener == null) {
            mListener = new QtiImsExtListenerBinder();
        }
        return mListener;
    }

    public void onSetCallForwardUncondTimer(int phoneId, int status) {
    }

    public void onGetCallForwardUncondTimer(int phoneId, int startHour, int endHour,
            int startMinute, int endMinute, int reason, int status, String number, int service) {
    }

    public void onUTReqFailed(int phoneId, int errCode, String errString) {
    }

    public void receiveCancelModifyCallResponse(int phoneId, int result) {
    }

    public void notifyVopsStatus(int phoneId, boolean vopsStatus) {
    }

    public void notifySsacStatus(int phoneId, boolean ssacStatusResponse) {
    }

    public void notifyParticipantStatusInfo(int phoneId, int operation, int sipStatus,
            String participantUri, boolean isEct) {
    }

    public void onVoltePreferenceUpdated(int phoneId, int result) {
    }

    public void onVoltePreferenceQueried(int phoneId, int result, int mode) {
    }

    public void onSetHandoverConfig(int phoneId, int result) {
    }

    public void onGetHandoverConfig(int phoneId, int result, int hoConfig) {
    }

    /**
     * This API is invoked when USSD put on IMS pipe at network fails
     * and is a temporary solution to notify clients about failures as
     * current vendor implementation doesn't support USSD over IMS
     * request from client.
     * @param type - should be used to map USSD UNSOL on CS pipe with
     *        USSD put on IMS pipe at network failure.
     */
    public void onUssdFailed(int phoneId, int type, int errorCode,
            String errorMessage) {
    }

    public void queryCallForwardStatusResponse(int phoneId, ImsCallForwardInfo[] cfInfoList) {
    }

    public void queryCallBarringResponse(int[] response) {
    }

    public void onScbmExited(boolean status) {
    }

    public void notifyDataChannelCapability(int phoneId, boolean dcCapability) {
    }

    public void handleSendVosSupportStatusResponse(int phoneId, int result) {
    }

    public void handleSendVosActionInfoResponse(int phoneId, int result) {
    }

    public void onSetGlassesFree3dVideoCapabilityResponse(int phoneId, int result) {
    }

    public void onIncomingRttVtUpgrade() {
    }
}
