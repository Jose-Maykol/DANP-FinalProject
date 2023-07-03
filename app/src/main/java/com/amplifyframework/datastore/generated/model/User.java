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

/** This is an auto generated class representing the User type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Users", type = Model.Type.USER, version = 1, authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
public final class User implements Model {
  public static final QueryField ID = field("User", "id");
  public static final QueryField NOMBRES = field("User", "nombres");
  public static final QueryField APELLIDOS = field("User", "apellidos");
  public static final QueryField EMAIL = field("User", "email");
  public static final QueryField PASSWORD = field("User", "password");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String") String nombres;
  private final @ModelField(targetType="String") String apellidos;
  private final @ModelField(targetType="String") String email;
  private final @ModelField(targetType="String") String password;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String resolveIdentifier() {
    return id;
  }
  
  public String getId() {
      return id;
  }
  
  public String getNombres() {
      return nombres;
  }
  
  public String getApellidos() {
      return apellidos;
  }
  
  public String getEmail() {
      return email;
  }
  
  public String getPassword() {
      return password;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private User(String id, String nombres, String apellidos, String email, String password) {
    this.id = id;
    this.nombres = nombres;
    this.apellidos = apellidos;
    this.email = email;
    this.password = password;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      User user = (User) obj;
      return ObjectsCompat.equals(getId(), user.getId()) &&
              ObjectsCompat.equals(getNombres(), user.getNombres()) &&
              ObjectsCompat.equals(getApellidos(), user.getApellidos()) &&
              ObjectsCompat.equals(getEmail(), user.getEmail()) &&
              ObjectsCompat.equals(getPassword(), user.getPassword()) &&
              ObjectsCompat.equals(getCreatedAt(), user.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), user.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getNombres())
      .append(getApellidos())
      .append(getEmail())
      .append(getPassword())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("User {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("nombres=" + String.valueOf(getNombres()) + ", ")
      .append("apellidos=" + String.valueOf(getApellidos()) + ", ")
      .append("email=" + String.valueOf(getEmail()) + ", ")
      .append("password=" + String.valueOf(getPassword()) + ", ")
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
  public static User justId(String id) {
    return new User(
      id,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      nombres,
      apellidos,
      email,
      password);
  }
  public interface BuildStep {
    User build();
    BuildStep id(String id);
    BuildStep nombres(String nombres);
    BuildStep apellidos(String apellidos);
    BuildStep email(String email);
    BuildStep password(String password);
  }
  

  public static class Builder implements BuildStep {
    private String id;
    private String nombres;
    private String apellidos;
    private String email;
    private String password;
    @Override
     public User build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new User(
          id,
          nombres,
          apellidos,
          email,
          password);
    }
    
    @Override
     public BuildStep nombres(String nombres) {
        this.nombres = nombres;
        return this;
    }
    
    @Override
     public BuildStep apellidos(String apellidos) {
        this.apellidos = apellidos;
        return this;
    }
    
    @Override
     public BuildStep email(String email) {
        this.email = email;
        return this;
    }
    
    @Override
     public BuildStep password(String password) {
        this.password = password;
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
    private CopyOfBuilder(String id, String nombres, String apellidos, String email, String password) {
      super.id(id);
      super.nombres(nombres)
        .apellidos(apellidos)
        .email(email)
        .password(password);
    }
    
    @Override
     public CopyOfBuilder nombres(String nombres) {
      return (CopyOfBuilder) super.nombres(nombres);
    }
    
    @Override
     public CopyOfBuilder apellidos(String apellidos) {
      return (CopyOfBuilder) super.apellidos(apellidos);
    }
    
    @Override
     public CopyOfBuilder email(String email) {
      return (CopyOfBuilder) super.email(email);
    }
    
    @Override
     public CopyOfBuilder password(String password) {
      return (CopyOfBuilder) super.password(password);
    }
  }
  
}
