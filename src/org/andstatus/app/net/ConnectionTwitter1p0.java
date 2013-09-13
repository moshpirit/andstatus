package org.andstatus.app.net;

import org.andstatus.app.origin.OriginConnectionData;
import org.json.JSONObject;

/**
 * Twitter API v.1 https://dev.twitter.com/docs/api/1
 *
 */
public class ConnectionTwitter1p0 extends ConnectionTwitter {

    public ConnectionTwitter1p0(OriginConnectionData connectionData) {
        super(connectionData);
    }

    @Override
    public MbMessage createFavorite(String statusId) throws ConnectionException {
        StringBuilder path = new StringBuilder(getApiPath(ApiRoutineEnum.CREATE_FAVORITE));
        path.append(statusId);
        path.append(EXTENSION);
        JSONObject jso = httpConnection.postRequest(path.toString());
        return messageFromJson(jso);
    }

    @Override
    public MbMessage destroyFavorite(String statusId) throws ConnectionException {
        StringBuilder path = new StringBuilder(getApiPath(ApiRoutineEnum.DESTROY_FAVORITE));
        path.append(statusId);
        path.append(EXTENSION);
        JSONObject jso = httpConnection.postRequest(path.toString());
        return messageFromJson(jso);
    }
}
