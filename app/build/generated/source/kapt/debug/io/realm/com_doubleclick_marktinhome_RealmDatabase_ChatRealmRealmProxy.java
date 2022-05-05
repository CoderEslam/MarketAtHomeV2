package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ImportFlag;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.NativeContext;
import io.realm.internal.OsList;
import io.realm.internal.OsMap;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.OsSet;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.internal.core.NativeRealmAny;
import io.realm.internal.objectstore.OsObjectBuilder;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxy extends com.doubleclick.marktinhome.RealmDatabase.ChatRealm
    implements RealmObjectProxy, com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxyInterface {

    static final class ChatRealmColumnInfo extends ColumnInfo {
        long primaryIdColKey;
        long idColKey;
        long messageColKey;
        long typeColKey;
        long senderColKey;
        long receiverColKey;
        long dateColKey;
        long StatusMessageColKey;

        ChatRealmColumnInfo(OsSchemaInfo schemaInfo) {
            super(8);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("ChatRealm");
            this.primaryIdColKey = addColumnDetails("primaryId", "primaryId", objectSchemaInfo);
            this.idColKey = addColumnDetails("id", "id", objectSchemaInfo);
            this.messageColKey = addColumnDetails("message", "message", objectSchemaInfo);
            this.typeColKey = addColumnDetails("type", "type", objectSchemaInfo);
            this.senderColKey = addColumnDetails("sender", "sender", objectSchemaInfo);
            this.receiverColKey = addColumnDetails("receiver", "receiver", objectSchemaInfo);
            this.dateColKey = addColumnDetails("date", "date", objectSchemaInfo);
            this.StatusMessageColKey = addColumnDetails("StatusMessage", "StatusMessage", objectSchemaInfo);
        }

        ChatRealmColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new ChatRealmColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final ChatRealmColumnInfo src = (ChatRealmColumnInfo) rawSrc;
            final ChatRealmColumnInfo dst = (ChatRealmColumnInfo) rawDst;
            dst.primaryIdColKey = src.primaryIdColKey;
            dst.idColKey = src.idColKey;
            dst.messageColKey = src.messageColKey;
            dst.typeColKey = src.typeColKey;
            dst.senderColKey = src.senderColKey;
            dst.receiverColKey = src.receiverColKey;
            dst.dateColKey = src.dateColKey;
            dst.StatusMessageColKey = src.StatusMessageColKey;
        }
    }

    private static final String NO_ALIAS = "";
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private ChatRealmColumnInfo columnInfo;
    private ProxyState<com.doubleclick.marktinhome.RealmDatabase.ChatRealm> proxyState;

    com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ChatRealmColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.doubleclick.marktinhome.RealmDatabase.ChatRealm>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$primaryId() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.primaryIdColKey);
    }

    @Override
    public void realmSet$primaryId(int value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'primaryId' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.idColKey);
    }

    @Override
    public void realmSet$id(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.idColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.idColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.idColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.idColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$message() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.messageColKey);
    }

    @Override
    public void realmSet$message(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.messageColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.messageColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.messageColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.messageColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$type() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.typeColKey);
    }

    @Override
    public void realmSet$type(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.typeColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.typeColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.typeColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.typeColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$sender() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.senderColKey);
    }

    @Override
    public void realmSet$sender(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.senderColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.senderColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.senderColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.senderColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$receiver() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.receiverColKey);
    }

    @Override
    public void realmSet$receiver(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.receiverColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.receiverColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.receiverColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.receiverColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$date() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.dateColKey);
    }

    @Override
    public void realmSet$date(long value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.dateColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.dateColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$StatusMessage() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.StatusMessageColKey);
    }

    @Override
    public void realmSet$StatusMessage(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.StatusMessageColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.StatusMessageColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.StatusMessageColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.StatusMessageColKey, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder(NO_ALIAS, "ChatRealm", false, 8, 0);
        builder.addPersistedProperty(NO_ALIAS, "primaryId", RealmFieldType.INTEGER, Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "id", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "message", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "type", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "sender", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "receiver", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "date", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "StatusMessage", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static ChatRealmColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new ChatRealmColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "ChatRealm";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "ChatRealm";
    }

    @SuppressWarnings("cast")
    public static com.doubleclick.marktinhome.RealmDatabase.ChatRealm createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.doubleclick.marktinhome.RealmDatabase.ChatRealm obj = null;
        if (update) {
            Table table = realm.getTable(com.doubleclick.marktinhome.RealmDatabase.ChatRealm.class);
            ChatRealmColumnInfo columnInfo = (ChatRealmColumnInfo) realm.getSchema().getColumnInfo(com.doubleclick.marktinhome.RealmDatabase.ChatRealm.class);
            long pkColumnKey = columnInfo.primaryIdColKey;
            long objKey = Table.NO_MATCH;
            if (!json.isNull("primaryId")) {
                objKey = table.findFirstLong(pkColumnKey, json.getLong("primaryId"));
            }
            if (objKey != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(objKey), realm.getSchema().getColumnInfo(com.doubleclick.marktinhome.RealmDatabase.ChatRealm.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("primaryId")) {
                if (json.isNull("primaryId")) {
                    obj = (io.realm.com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxy) realm.createObjectInternal(com.doubleclick.marktinhome.RealmDatabase.ChatRealm.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxy) realm.createObjectInternal(com.doubleclick.marktinhome.RealmDatabase.ChatRealm.class, json.getInt("primaryId"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'primaryId'.");
            }
        }

        final com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxyInterface objProxy = (com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxyInterface) obj;
        if (json.has("id")) {
            if (json.isNull("id")) {
                objProxy.realmSet$id(null);
            } else {
                objProxy.realmSet$id((String) json.getString("id"));
            }
        }
        if (json.has("message")) {
            if (json.isNull("message")) {
                objProxy.realmSet$message(null);
            } else {
                objProxy.realmSet$message((String) json.getString("message"));
            }
        }
        if (json.has("type")) {
            if (json.isNull("type")) {
                objProxy.realmSet$type(null);
            } else {
                objProxy.realmSet$type((String) json.getString("type"));
            }
        }
        if (json.has("sender")) {
            if (json.isNull("sender")) {
                objProxy.realmSet$sender(null);
            } else {
                objProxy.realmSet$sender((String) json.getString("sender"));
            }
        }
        if (json.has("receiver")) {
            if (json.isNull("receiver")) {
                objProxy.realmSet$receiver(null);
            } else {
                objProxy.realmSet$receiver((String) json.getString("receiver"));
            }
        }
        if (json.has("date")) {
            if (json.isNull("date")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'date' to null.");
            } else {
                objProxy.realmSet$date((long) json.getLong("date"));
            }
        }
        if (json.has("StatusMessage")) {
            if (json.isNull("StatusMessage")) {
                objProxy.realmSet$StatusMessage(null);
            } else {
                objProxy.realmSet$StatusMessage((String) json.getString("StatusMessage"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.doubleclick.marktinhome.RealmDatabase.ChatRealm createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.doubleclick.marktinhome.RealmDatabase.ChatRealm obj = new com.doubleclick.marktinhome.RealmDatabase.ChatRealm();
        final com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxyInterface objProxy = (com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("primaryId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$primaryId((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'primaryId' to null.");
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$id(null);
                }
            } else if (name.equals("message")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$message((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$message(null);
                }
            } else if (name.equals("type")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$type((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$type(null);
                }
            } else if (name.equals("sender")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sender((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$sender(null);
                }
            } else if (name.equals("receiver")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$receiver((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$receiver(null);
                }
            } else if (name.equals("date")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$date((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'date' to null.");
                }
            } else if (name.equals("StatusMessage")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$StatusMessage((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$StatusMessage(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'primaryId'.");
        }
        return realm.copyToRealmOrUpdate(obj);
    }

    static com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.doubleclick.marktinhome.RealmDatabase.ChatRealm.class), false, Collections.<String>emptyList());
        io.realm.com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxy obj = new io.realm.com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.doubleclick.marktinhome.RealmDatabase.ChatRealm copyOrUpdate(Realm realm, ChatRealmColumnInfo columnInfo, com.doubleclick.marktinhome.RealmDatabase.ChatRealm object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.doubleclick.marktinhome.RealmDatabase.ChatRealm) cachedRealmObject;
        }

        com.doubleclick.marktinhome.RealmDatabase.ChatRealm realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.doubleclick.marktinhome.RealmDatabase.ChatRealm.class);
            long pkColumnKey = columnInfo.primaryIdColKey;
            long objKey = table.findFirstLong(pkColumnKey, ((com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxyInterface) object).realmGet$primaryId());
            if (objKey == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(objKey), columnInfo, false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.doubleclick.marktinhome.RealmDatabase.ChatRealm copy(Realm realm, ChatRealmColumnInfo columnInfo, com.doubleclick.marktinhome.RealmDatabase.ChatRealm newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.doubleclick.marktinhome.RealmDatabase.ChatRealm) cachedRealmObject;
        }

        com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxyInterface unmanagedSource = (com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxyInterface) newObject;

        Table table = realm.getTable(com.doubleclick.marktinhome.RealmDatabase.ChatRealm.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.primaryIdColKey, unmanagedSource.realmGet$primaryId());
        builder.addString(columnInfo.idColKey, unmanagedSource.realmGet$id());
        builder.addString(columnInfo.messageColKey, unmanagedSource.realmGet$message());
        builder.addString(columnInfo.typeColKey, unmanagedSource.realmGet$type());
        builder.addString(columnInfo.senderColKey, unmanagedSource.realmGet$sender());
        builder.addString(columnInfo.receiverColKey, unmanagedSource.realmGet$receiver());
        builder.addInteger(columnInfo.dateColKey, unmanagedSource.realmGet$date());
        builder.addString(columnInfo.StatusMessageColKey, unmanagedSource.realmGet$StatusMessage());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxy managedCopy = newProxyInstance(realm, row);
        cache.put(newObject, managedCopy);

        return managedCopy;
    }

    public static long insert(Realm realm, com.doubleclick.marktinhome.RealmDatabase.ChatRealm object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.doubleclick.marktinhome.RealmDatabase.ChatRealm.class);
        long tableNativePtr = table.getNativePtr();
        ChatRealmColumnInfo columnInfo = (ChatRealmColumnInfo) realm.getSchema().getColumnInfo(com.doubleclick.marktinhome.RealmDatabase.ChatRealm.class);
        long pkColumnKey = columnInfo.primaryIdColKey;
        long objKey = Table.NO_MATCH;
        Object primaryKeyValue = ((com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxyInterface) object).realmGet$primaryId();
        if (primaryKeyValue != null) {
            objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxyInterface) object).realmGet$primaryId());
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxyInterface) object).realmGet$primaryId());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, objKey);
        String realmGet$id = ((com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxyInterface) object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.idColKey, objKey, realmGet$id, false);
        }
        String realmGet$message = ((com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxyInterface) object).realmGet$message();
        if (realmGet$message != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.messageColKey, objKey, realmGet$message, false);
        }
        String realmGet$type = ((com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxyInterface) object).realmGet$type();
        if (realmGet$type != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.typeColKey, objKey, realmGet$type, false);
        }
        String realmGet$sender = ((com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxyInterface) object).realmGet$sender();
        if (realmGet$sender != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.senderColKey, objKey, realmGet$sender, false);
        }
        String realmGet$receiver = ((com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxyInterface) object).realmGet$receiver();
        if (realmGet$receiver != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.receiverColKey, objKey, realmGet$receiver, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.dateColKey, objKey, ((com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxyInterface) object).realmGet$date(), false);
        String realmGet$StatusMessage = ((com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxyInterface) object).realmGet$StatusMessage();
        if (realmGet$StatusMessage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.StatusMessageColKey, objKey, realmGet$StatusMessage, false);
        }
        return objKey;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.doubleclick.marktinhome.RealmDatabase.ChatRealm.class);
        long tableNativePtr = table.getNativePtr();
        ChatRealmColumnInfo columnInfo = (ChatRealmColumnInfo) realm.getSchema().getColumnInfo(com.doubleclick.marktinhome.RealmDatabase.ChatRealm.class);
        long pkColumnKey = columnInfo.primaryIdColKey;
        com.doubleclick.marktinhome.RealmDatabase.ChatRealm object = null;
        while (objects.hasNext()) {
            object = (com.doubleclick.marktinhome.RealmDatabase.ChatRealm) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            long objKey = Table.NO_MATCH;
            Object primaryKeyValue = ((com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxyInterface) object).realmGet$primaryId();
            if (primaryKeyValue != null) {
                objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxyInterface) object).realmGet$primaryId());
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxyInterface) object).realmGet$primaryId());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, objKey);
            String realmGet$id = ((com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxyInterface) object).realmGet$id();
            if (realmGet$id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.idColKey, objKey, realmGet$id, false);
            }
            String realmGet$message = ((com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxyInterface) object).realmGet$message();
            if (realmGet$message != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.messageColKey, objKey, realmGet$message, false);
            }
            String realmGet$type = ((com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxyInterface) object).realmGet$type();
            if (realmGet$type != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.typeColKey, objKey, realmGet$type, false);
            }
            String realmGet$sender = ((com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxyInterface) object).realmGet$sender();
            if (realmGet$sender != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.senderColKey, objKey, realmGet$sender, false);
            }
            String realmGet$receiver = ((com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxyInterface) object).realmGet$receiver();
            if (realmGet$receiver != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.receiverColKey, objKey, realmGet$receiver, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.dateColKey, objKey, ((com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxyInterface) object).realmGet$date(), false);
            String realmGet$StatusMessage = ((com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxyInterface) object).realmGet$StatusMessage();
            if (realmGet$StatusMessage != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.StatusMessageColKey, objKey, realmGet$StatusMessage, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.doubleclick.marktinhome.RealmDatabase.ChatRealm object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.doubleclick.marktinhome.RealmDatabase.ChatRealm.class);
        long tableNativePtr = table.getNativePtr();
        ChatRealmColumnInfo columnInfo = (ChatRealmColumnInfo) realm.getSchema().getColumnInfo(com.doubleclick.marktinhome.RealmDatabase.ChatRealm.class);
        long pkColumnKey = columnInfo.primaryIdColKey;
        long objKey = Table.NO_MATCH;
        Object primaryKeyValue = ((com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxyInterface) object).realmGet$primaryId();
        if (primaryKeyValue != null) {
            objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxyInterface) object).realmGet$primaryId());
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxyInterface) object).realmGet$primaryId());
        }
        cache.put(object, objKey);
        String realmGet$id = ((com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxyInterface) object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.idColKey, objKey, realmGet$id, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.idColKey, objKey, false);
        }
        String realmGet$message = ((com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxyInterface) object).realmGet$message();
        if (realmGet$message != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.messageColKey, objKey, realmGet$message, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.messageColKey, objKey, false);
        }
        String realmGet$type = ((com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxyInterface) object).realmGet$type();
        if (realmGet$type != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.typeColKey, objKey, realmGet$type, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.typeColKey, objKey, false);
        }
        String realmGet$sender = ((com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxyInterface) object).realmGet$sender();
        if (realmGet$sender != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.senderColKey, objKey, realmGet$sender, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.senderColKey, objKey, false);
        }
        String realmGet$receiver = ((com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxyInterface) object).realmGet$receiver();
        if (realmGet$receiver != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.receiverColKey, objKey, realmGet$receiver, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.receiverColKey, objKey, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.dateColKey, objKey, ((com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxyInterface) object).realmGet$date(), false);
        String realmGet$StatusMessage = ((com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxyInterface) object).realmGet$StatusMessage();
        if (realmGet$StatusMessage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.StatusMessageColKey, objKey, realmGet$StatusMessage, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.StatusMessageColKey, objKey, false);
        }
        return objKey;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.doubleclick.marktinhome.RealmDatabase.ChatRealm.class);
        long tableNativePtr = table.getNativePtr();
        ChatRealmColumnInfo columnInfo = (ChatRealmColumnInfo) realm.getSchema().getColumnInfo(com.doubleclick.marktinhome.RealmDatabase.ChatRealm.class);
        long pkColumnKey = columnInfo.primaryIdColKey;
        com.doubleclick.marktinhome.RealmDatabase.ChatRealm object = null;
        while (objects.hasNext()) {
            object = (com.doubleclick.marktinhome.RealmDatabase.ChatRealm) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            long objKey = Table.NO_MATCH;
            Object primaryKeyValue = ((com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxyInterface) object).realmGet$primaryId();
            if (primaryKeyValue != null) {
                objKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxyInterface) object).realmGet$primaryId());
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxyInterface) object).realmGet$primaryId());
            }
            cache.put(object, objKey);
            String realmGet$id = ((com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxyInterface) object).realmGet$id();
            if (realmGet$id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.idColKey, objKey, realmGet$id, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.idColKey, objKey, false);
            }
            String realmGet$message = ((com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxyInterface) object).realmGet$message();
            if (realmGet$message != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.messageColKey, objKey, realmGet$message, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.messageColKey, objKey, false);
            }
            String realmGet$type = ((com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxyInterface) object).realmGet$type();
            if (realmGet$type != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.typeColKey, objKey, realmGet$type, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.typeColKey, objKey, false);
            }
            String realmGet$sender = ((com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxyInterface) object).realmGet$sender();
            if (realmGet$sender != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.senderColKey, objKey, realmGet$sender, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.senderColKey, objKey, false);
            }
            String realmGet$receiver = ((com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxyInterface) object).realmGet$receiver();
            if (realmGet$receiver != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.receiverColKey, objKey, realmGet$receiver, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.receiverColKey, objKey, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.dateColKey, objKey, ((com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxyInterface) object).realmGet$date(), false);
            String realmGet$StatusMessage = ((com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxyInterface) object).realmGet$StatusMessage();
            if (realmGet$StatusMessage != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.StatusMessageColKey, objKey, realmGet$StatusMessage, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.StatusMessageColKey, objKey, false);
            }
        }
    }

    public static com.doubleclick.marktinhome.RealmDatabase.ChatRealm createDetachedCopy(com.doubleclick.marktinhome.RealmDatabase.ChatRealm realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.doubleclick.marktinhome.RealmDatabase.ChatRealm unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.doubleclick.marktinhome.RealmDatabase.ChatRealm();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.doubleclick.marktinhome.RealmDatabase.ChatRealm) cachedObject.object;
            }
            unmanagedObject = (com.doubleclick.marktinhome.RealmDatabase.ChatRealm) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxyInterface unmanagedCopy = (com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxyInterface) unmanagedObject;
        com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxyInterface realmSource = (com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxyInterface) realmObject;
        Realm objectRealm = (Realm) ((RealmObjectProxy) realmObject).realmGet$proxyState().getRealm$realm();
        unmanagedCopy.realmSet$primaryId(realmSource.realmGet$primaryId());
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$message(realmSource.realmGet$message());
        unmanagedCopy.realmSet$type(realmSource.realmGet$type());
        unmanagedCopy.realmSet$sender(realmSource.realmGet$sender());
        unmanagedCopy.realmSet$receiver(realmSource.realmGet$receiver());
        unmanagedCopy.realmSet$date(realmSource.realmGet$date());
        unmanagedCopy.realmSet$StatusMessage(realmSource.realmGet$StatusMessage());

        return unmanagedObject;
    }

    static com.doubleclick.marktinhome.RealmDatabase.ChatRealm update(Realm realm, ChatRealmColumnInfo columnInfo, com.doubleclick.marktinhome.RealmDatabase.ChatRealm realmObject, com.doubleclick.marktinhome.RealmDatabase.ChatRealm newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxyInterface realmObjectTarget = (com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxyInterface) realmObject;
        com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxyInterface realmObjectSource = (com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxyInterface) newObject;
        Table table = realm.getTable(com.doubleclick.marktinhome.RealmDatabase.ChatRealm.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);
        builder.addInteger(columnInfo.primaryIdColKey, realmObjectSource.realmGet$primaryId());
        builder.addString(columnInfo.idColKey, realmObjectSource.realmGet$id());
        builder.addString(columnInfo.messageColKey, realmObjectSource.realmGet$message());
        builder.addString(columnInfo.typeColKey, realmObjectSource.realmGet$type());
        builder.addString(columnInfo.senderColKey, realmObjectSource.realmGet$sender());
        builder.addString(columnInfo.receiverColKey, realmObjectSource.realmGet$receiver());
        builder.addInteger(columnInfo.dateColKey, realmObjectSource.realmGet$date());
        builder.addString(columnInfo.StatusMessageColKey, realmObjectSource.realmGet$StatusMessage());

        builder.updateExistingTopLevelObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("ChatRealm = proxy[");
        stringBuilder.append("{primaryId:");
        stringBuilder.append(realmGet$primaryId());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{message:");
        stringBuilder.append(realmGet$message() != null ? realmGet$message() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{type:");
        stringBuilder.append(realmGet$type() != null ? realmGet$type() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sender:");
        stringBuilder.append(realmGet$sender() != null ? realmGet$sender() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{receiver:");
        stringBuilder.append(realmGet$receiver() != null ? realmGet$receiver() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{date:");
        stringBuilder.append(realmGet$date());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{StatusMessage:");
        stringBuilder.append(realmGet$StatusMessage() != null ? realmGet$StatusMessage() : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long objKey = proxyState.getRow$realm().getObjectKey();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (objKey ^ (objKey >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxy aChatRealm = (com_doubleclick_marktinhome_RealmDatabase_ChatRealmRealmProxy)o;

        BaseRealm realm = proxyState.getRealm$realm();
        BaseRealm otherRealm = aChatRealm.proxyState.getRealm$realm();
        String path = realm.getPath();
        String otherPath = otherRealm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;
        if (realm.isFrozen() != otherRealm.isFrozen()) return false;
        if (!realm.sharedRealm.getVersionID().equals(otherRealm.sharedRealm.getVersionID())) {
            return false;
        }

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aChatRealm.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getObjectKey() != aChatRealm.proxyState.getRow$realm().getObjectKey()) return false;

        return true;
    }
}
