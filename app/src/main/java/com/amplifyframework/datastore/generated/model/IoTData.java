package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.temporal.Temporal;

import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.AuthStrategy;
import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.ModelOperation;
import com.amplifyframework.core.model.annotations.AuthRule;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the IoTData type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "IoTData", type = Model.Type.USER, version = 1, authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
public final class IoTData implements Model {
  public static final QueryField ID = field("IoTData", "id");
  public static final QueryField DATETIME = field("IoTData", "datetime");
  public static final QueryField HUMIDITY = field("IoTData", "humidity");
  public static final QueryField TEMPERATURE = field("IoTData", "temperature");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String") String datetime;
  private final @ModelField(targetType="String") String humidity;
  private final @ModelField(targetType="String") String temperature;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String resolveIdentifier() {
    return id;
  }
  
  public String getId() {
      return id;
  }
  
  public String getDatetime() {
      return datetime;
  }
  
  public String getHumidity() {
      return humidity;
  }
  
  public String getTemperature() {
      return temperature;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private IoTData(String id, String datetime, String humidity, String temperature) {
    this.id = id;
    this.datetime = datetime;
    this.humidity = humidity;
    this.temperature = temperature;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      IoTData ioTData = (IoTData) obj;
      return ObjectsCompat.equals(getId(), ioTData.getId()) &&
              ObjectsCompat.equals(getDatetime(), ioTData.getDatetime()) &&
              ObjectsCompat.equals(getHumidity(), ioTData.getHumidity()) &&
              ObjectsCompat.equals(getTemperature(), ioTData.getTemperature()) &&
              ObjectsCompat.equals(getCreatedAt(), ioTData.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), ioTData.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getDatetime())
      .append(getHumidity())
      .append(getTemperature())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("IoTData {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("datetime=" + String.valueOf(getDatetime()) + ", ")
      .append("humidity=" + String.valueOf(getHumidity()) + ", ")
      .append("temperature=" + String.valueOf(getTemperature()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static BuildStep builder() {
      return new Builder();
  }
  
  /**
   * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
   * This is a convenience method to return an instance of the object with only its ID populated
   * to be used in the context of a parameter in a delete mutation or referencing a foreign key
   * in a relationship.
   * @param id the id of the existing item this instance will represent
   * @return an instance of this model with only ID populated
   */
  public static IoTData justId(String id) {
    return new IoTData(
      id,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      datetime,
      humidity,
      temperature);
  }
  public interface BuildStep {
    IoTData build();
    BuildStep id(String id);
    BuildStep datetime(String datetime);
    BuildStep humidity(String humidity);
    BuildStep temperature(String temperature);
  }
  

  public static class Builder implements BuildStep {
    private String id;
    private String datetime;
    private String humidity;
    private String temperature;
    @Override
     public IoTData build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new IoTData(
          id,
          datetime,
          humidity,
          temperature);
    }
    
    @Override
     public BuildStep datetime(String datetime) {
        this.datetime = datetime;
        return this;
    }
    
    @Override
     public BuildStep humidity(String humidity) {
        this.humidity = humidity;
        return this;
    }
    
    @Override
     public BuildStep temperature(String temperature) {
        this.temperature = temperature;
        return this;
    }
    
    /**
     * @param id id
     * @return Current Builder instance, for fluent method chaining
     */
    public BuildStep id(String id) {
        this.id = id;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, String datetime, String humidity, String temperature) {
      super.id(id);
      super.datetime(datetime)
        .humidity(humidity)
        .temperature(temperature);
    }
    
    @Override
     public CopyOfBuilder datetime(String datetime) {
      return (CopyOfBuilder) super.datetime(datetime);
    }
    
    @Override
     public CopyOfBuilder humidity(String humidity) {
      return (CopyOfBuilder) super.humidity(humidity);
    }
    
    @Override
     public CopyOfBuilder temperature(String temperature) {
      return (CopyOfBuilder) super.temperature(temperature);
    }
  }
  
}
