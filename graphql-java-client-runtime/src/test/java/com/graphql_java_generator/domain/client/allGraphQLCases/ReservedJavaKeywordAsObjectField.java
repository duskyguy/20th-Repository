/** Generated by the default template from graphql-java-generator */
package com.graphql_java_generator.domain.client.allGraphQLCases;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.graphql_java_generator.annotation.GraphQLInputParameters;
import com.graphql_java_generator.annotation.GraphQLNonScalar;
import com.graphql_java_generator.annotation.GraphQLObjectType;
import com.graphql_java_generator.annotation.GraphQLScalar;

/**
 *
 * @author generated by graphql-java-generator
 * @see <a href="https://github.com/graphql-java-generator/graphql-java-generator">https://github.com/graphql-java-generator/graphql-java-generator</a>
 */
@GraphQLObjectType("ReservedJavaKeywordAsObjectField")
@JsonInclude(Include.NON_NULL)
@SuppressWarnings("unused")
public class ReservedJavaKeywordAsObjectField 
{


	/**
	 * This map contains the deserialized values for the alias, as parsed from the json response from the GraphQL
	 * server. The key is the alias name, the value is the deserialiazed value (taking into account custom scalars,
	 * lists, ...)
	 */
	@com.graphql_java_generator.annotation.GraphQLIgnore
	Map<String, Object> aliasValues = new HashMap<>();

	public ReservedJavaKeywordAsObjectField(){
		// No action
	}

	/**
	 *  Parameters should also be protected
	 */
	@JsonProperty("if")
	@GraphQLInputParameters(names = {"new", "package", "private"}, types = {"String", "String", "String"}, mandatories = {false, false, false}, listDepths = {0, 0, 0}, itemsMandatory = {false, false, false})
	@GraphQLNonScalar(fieldName = "if", graphQLTypeSimpleName = "Human", javaClass = Human.class)
	Human _if;


	@JsonProperty("implements")
	@GraphQLNonScalar(fieldName = "implements", graphQLTypeSimpleName = "Human", javaClass = Human.class)
	Human _implements;


	@JsonProperty("import")
	@GraphQLNonScalar(fieldName = "import", graphQLTypeSimpleName = "Human", javaClass = Human.class)
	Human _import;


	@JsonProperty("instanceof")
	@GraphQLNonScalar(fieldName = "instanceof", graphQLTypeSimpleName = "Human", javaClass = Human.class)
	Human _instanceof;


	@JsonProperty("int")
	@GraphQLNonScalar(fieldName = "int", graphQLTypeSimpleName = "Human", javaClass = Human.class)
	Human _int;


	@JsonProperty("interface")
	@GraphQLNonScalar(fieldName = "interface", graphQLTypeSimpleName = "Human", javaClass = Human.class)
	Human _interface;


	@JsonProperty("long")
	@GraphQLNonScalar(fieldName = "long", graphQLTypeSimpleName = "Human", javaClass = Human.class)
	Human _long;


	@JsonProperty("native")
	@GraphQLNonScalar(fieldName = "native", graphQLTypeSimpleName = "Human", javaClass = Human.class)
	Human _native;


	@JsonProperty("new")
	@GraphQLNonScalar(fieldName = "new", graphQLTypeSimpleName = "Human", javaClass = Human.class)
	Human _new;


	@JsonProperty("package")
	@GraphQLNonScalar(fieldName = "package", graphQLTypeSimpleName = "Human", javaClass = Human.class)
	Human _package;


	@JsonProperty("private")
	@GraphQLNonScalar(fieldName = "private", graphQLTypeSimpleName = "Human", javaClass = Human.class)
	Human _private;


	@JsonProperty("protected")
	@GraphQLNonScalar(fieldName = "protected", graphQLTypeSimpleName = "Human", javaClass = Human.class)
	Human _protected;


	@JsonProperty("public")
	@GraphQLNonScalar(fieldName = "public", graphQLTypeSimpleName = "Human", javaClass = Human.class)
	Human _public;


	@JsonProperty("return")
	@GraphQLNonScalar(fieldName = "return", graphQLTypeSimpleName = "Human", javaClass = Human.class)
	Human _return;


	@JsonProperty("short")
	@GraphQLNonScalar(fieldName = "short", graphQLTypeSimpleName = "Human", javaClass = Human.class)
	Human _short;


	@JsonProperty("static")
	@GraphQLNonScalar(fieldName = "static", graphQLTypeSimpleName = "Human", javaClass = Human.class)
	Human _static;


	@JsonProperty("strictfp")
	@GraphQLNonScalar(fieldName = "strictfp", graphQLTypeSimpleName = "Human", javaClass = Human.class)
	Human _strictfp;


	@JsonProperty("super")
	@GraphQLNonScalar(fieldName = "super", graphQLTypeSimpleName = "Human", javaClass = Human.class)
	Human _super;


	@JsonProperty("switch")
	@GraphQLNonScalar(fieldName = "switch", graphQLTypeSimpleName = "Human", javaClass = Human.class)
	Human _switch;


	@JsonProperty("synchronized")
	@GraphQLNonScalar(fieldName = "synchronized", graphQLTypeSimpleName = "Human", javaClass = Human.class)
	Human _synchronized;


	@JsonProperty("this")
	@GraphQLNonScalar(fieldName = "this", graphQLTypeSimpleName = "Human", javaClass = Human.class)
	Human _this;


	@JsonProperty("throw")
	@GraphQLNonScalar(fieldName = "throw", graphQLTypeSimpleName = "Human", javaClass = Human.class)
	Human _throw;


	@JsonProperty("throws")
	@GraphQLNonScalar(fieldName = "throws", graphQLTypeSimpleName = "Human", javaClass = Human.class)
	Human _throws;


	@JsonProperty("transient")
	@GraphQLNonScalar(fieldName = "transient", graphQLTypeSimpleName = "Human", javaClass = Human.class)
	Human _transient;


	@JsonProperty("try")
	@GraphQLNonScalar(fieldName = "try", graphQLTypeSimpleName = "Human", javaClass = Human.class)
	Human _try;


	@JsonProperty("void")
	@GraphQLNonScalar(fieldName = "void", graphQLTypeSimpleName = "Human", javaClass = Human.class)
	Human _void;


	@JsonProperty("volatile")
	@GraphQLNonScalar(fieldName = "volatile", graphQLTypeSimpleName = "Human", javaClass = Human.class)
	Human _volatile;


	@JsonProperty("while")
	@GraphQLNonScalar(fieldName = "while", graphQLTypeSimpleName = "Human", javaClass = Human.class)
	Human _while;


	@JsonProperty("__typename")
	@GraphQLScalar(fieldName = "__typename", graphQLTypeSimpleName = "String", javaClass = java.lang.String.class)
	java.lang.String __typename;



	/**
	 *  Parameters should also be protected
	 */
	public void setIf(Human _if) {
		this._if = _if;
	}

	/**
	 *  Parameters should also be protected
	*/
	public Human getIf() {
		return _if;
	}
		

	public void setImplements(Human _implements) {
		this._implements = _implements;
	}

	public Human getImplements() {
		return _implements;
	}
		

	public void setImport(Human _import) {
		this._import = _import;
	}

	public Human getImport() {
		return _import;
	}
		

	public void setInstanceof(Human _instanceof) {
		this._instanceof = _instanceof;
	}

	public Human getInstanceof() {
		return _instanceof;
	}
		

	public void setInt(Human _int) {
		this._int = _int;
	}

	public Human getInt() {
		return _int;
	}
		

	public void setInterface(Human _interface) {
		this._interface = _interface;
	}

	public Human getInterface() {
		return _interface;
	}
		

	public void setLong(Human _long) {
		this._long = _long;
	}

	public Human getLong() {
		return _long;
	}
		

	public void setNative(Human _native) {
		this._native = _native;
	}

	public Human getNative() {
		return _native;
	}
		

	public void setNew(Human _new) {
		this._new = _new;
	}

	public Human getNew() {
		return _new;
	}
		

	public void setPackage(Human _package) {
		this._package = _package;
	}

	public Human getPackage() {
		return _package;
	}
		

	public void setPrivate(Human _private) {
		this._private = _private;
	}

	public Human getPrivate() {
		return _private;
	}
		

	public void setProtected(Human _protected) {
		this._protected = _protected;
	}

	public Human getProtected() {
		return _protected;
	}
		

	public void setPublic(Human _public) {
		this._public = _public;
	}

	public Human getPublic() {
		return _public;
	}
		

	public void setReturn(Human _return) {
		this._return = _return;
	}

	public Human getReturn() {
		return _return;
	}
		

	public void setShort(Human _short) {
		this._short = _short;
	}

	public Human getShort() {
		return _short;
	}
		

	public void setStatic(Human _static) {
		this._static = _static;
	}

	public Human getStatic() {
		return _static;
	}
		

	public void setStrictfp(Human _strictfp) {
		this._strictfp = _strictfp;
	}

	public Human getStrictfp() {
		return _strictfp;
	}
		

	public void setSuper(Human _super) {
		this._super = _super;
	}

	public Human getSuper() {
		return _super;
	}
		

	public void setSwitch(Human _switch) {
		this._switch = _switch;
	}

	public Human getSwitch() {
		return _switch;
	}
		

	public void setSynchronized(Human _synchronized) {
		this._synchronized = _synchronized;
	}

	public Human getSynchronized() {
		return _synchronized;
	}
		

	public void setThis(Human _this) {
		this._this = _this;
	}

	public Human getThis() {
		return _this;
	}
		

	public void setThrow(Human _throw) {
		this._throw = _throw;
	}

	public Human getThrow() {
		return _throw;
	}
		

	public void setThrows(Human _throws) {
		this._throws = _throws;
	}

	public Human getThrows() {
		return _throws;
	}
		

	public void setTransient(Human _transient) {
		this._transient = _transient;
	}

	public Human getTransient() {
		return _transient;
	}
		

	public void setTry(Human _try) {
		this._try = _try;
	}

	public Human getTry() {
		return _try;
	}
		

	public void setVoid(Human _void) {
		this._void = _void;
	}

	public Human getVoid() {
		return _void;
	}
		

	public void setVolatile(Human _volatile) {
		this._volatile = _volatile;
	}

	public Human getVolatile() {
		return _volatile;
	}
		

	public void setWhile(Human _while) {
		this._while = _while;
	}

	public Human getWhile() {
		return _while;
	}
		

	public void set__typename(java.lang.String __typename) {
		this.__typename = __typename;
	}

	public java.lang.String get__typename() {
		return __typename;
	}
		

 
	/**
	 * This method is called during the json deserialization process, by the {@link GraphQLObjectMapper}, each time an
	 * alias value is read from the json.
	 * 
	 * @param aliasName
	 * @param aliasDeserializedValue
	 */
	public void setAliasValue(String aliasName, Object aliasDeserializedValue) {
		aliasValues.put(aliasName, aliasDeserializedValue);
	}

	/**
	 * Retrieves the value for the given alias, as it has been received for this object in the GraphQL response. <BR/>
	 * This method <B>should not be used for Custom Scalars</B>, as the parser doesn't know if this alias is a custom
	 * scalar, and which custom scalar to use at deserialization time. In most case, a value will then be provided by
	 * this method with a basis json deserialization, but this value won't be the proper custom scalar value.
	 * 
	 * @param alias
	 * @return
	 */
	public Object getAliasValue(String alias) {
		return aliasValues.get(alias);
	}

    public String toString() {
        return "ReservedJavaKeywordAsObjectField {"
				+ "_if: " + _if
				+ ", "
				+ "_implements: " + _implements
				+ ", "
				+ "_import: " + _import
				+ ", "
				+ "_instanceof: " + _instanceof
				+ ", "
				+ "_int: " + _int
				+ ", "
				+ "_interface: " + _interface
				+ ", "
				+ "_long: " + _long
				+ ", "
				+ "_native: " + _native
				+ ", "
				+ "_new: " + _new
				+ ", "
				+ "_package: " + _package
				+ ", "
				+ "_private: " + _private
				+ ", "
				+ "_protected: " + _protected
				+ ", "
				+ "_public: " + _public
				+ ", "
				+ "_return: " + _return
				+ ", "
				+ "_short: " + _short
				+ ", "
				+ "_static: " + _static
				+ ", "
				+ "_strictfp: " + _strictfp
				+ ", "
				+ "_super: " + _super
				+ ", "
				+ "_switch: " + _switch
				+ ", "
				+ "_synchronized: " + _synchronized
				+ ", "
				+ "_this: " + _this
				+ ", "
				+ "_throw: " + _throw
				+ ", "
				+ "_throws: " + _throws
				+ ", "
				+ "_transient: " + _transient
				+ ", "
				+ "_try: " + _try
				+ ", "
				+ "_void: " + _void
				+ ", "
				+ "_volatile: " + _volatile
				+ ", "
				+ "_while: " + _while
				+ ", "
				+ "__typename: " + __typename
        		+ "}";
    }

	public static Builder builder() {
		return new Builder();
	}

	/**
	 * The Builder that helps building instance of this POJO. You can get an instance of this class, by calling the
	 * {@link #builder()}
	 */
	public static class Builder {
		private Human _if;
		private Human _implements;
		private Human _import;
		private Human _instanceof;
		private Human _int;
		private Human _interface;
		private Human _long;
		private Human _native;
		private Human _new;
		private Human _package;
		private Human _private;
		private Human _protected;
		private Human _public;
		private Human _return;
		private Human _short;
		private Human _static;
		private Human _strictfp;
		private Human _super;
		private Human _switch;
		private Human _synchronized;
		private Human _this;
		private Human _throw;
		private Human _throws;
		private Human _transient;
		private Human _try;
		private Human _void;
		private Human _volatile;
		private Human _while;

		public Builder withIf(Human _if) {
			this._if = _if;
			return this;
		}
		public Builder withImplements(Human _implements) {
			this._implements = _implements;
			return this;
		}
		public Builder withImport(Human _import) {
			this._import = _import;
			return this;
		}
		public Builder withInstanceof(Human _instanceof) {
			this._instanceof = _instanceof;
			return this;
		}
		public Builder withInt(Human _int) {
			this._int = _int;
			return this;
		}
		public Builder withInterface(Human _interface) {
			this._interface = _interface;
			return this;
		}
		public Builder withLong(Human _long) {
			this._long = _long;
			return this;
		}
		public Builder withNative(Human _native) {
			this._native = _native;
			return this;
		}
		public Builder withNew(Human _new) {
			this._new = _new;
			return this;
		}
		public Builder withPackage(Human _package) {
			this._package = _package;
			return this;
		}
		public Builder withPrivate(Human _private) {
			this._private = _private;
			return this;
		}
		public Builder withProtected(Human _protected) {
			this._protected = _protected;
			return this;
		}
		public Builder withPublic(Human _public) {
			this._public = _public;
			return this;
		}
		public Builder withReturn(Human _return) {
			this._return = _return;
			return this;
		}
		public Builder withShort(Human _short) {
			this._short = _short;
			return this;
		}
		public Builder withStatic(Human _static) {
			this._static = _static;
			return this;
		}
		public Builder withStrictfp(Human _strictfp) {
			this._strictfp = _strictfp;
			return this;
		}
		public Builder withSuper(Human _super) {
			this._super = _super;
			return this;
		}
		public Builder withSwitch(Human _switch) {
			this._switch = _switch;
			return this;
		}
		public Builder withSynchronized(Human _synchronized) {
			this._synchronized = _synchronized;
			return this;
		}
		public Builder withThis(Human _this) {
			this._this = _this;
			return this;
		}
		public Builder withThrow(Human _throw) {
			this._throw = _throw;
			return this;
		}
		public Builder withThrows(Human _throws) {
			this._throws = _throws;
			return this;
		}
		public Builder withTransient(Human _transient) {
			this._transient = _transient;
			return this;
		}
		public Builder withTry(Human _try) {
			this._try = _try;
			return this;
		}
		public Builder withVoid(Human _void) {
			this._void = _void;
			return this;
		}
		public Builder withVolatile(Human _volatile) {
			this._volatile = _volatile;
			return this;
		}
		public Builder withWhile(Human _while) {
			this._while = _while;
			return this;
		}

		public ReservedJavaKeywordAsObjectField build() {
			ReservedJavaKeywordAsObjectField _object = new ReservedJavaKeywordAsObjectField();
			_object.setIf(_if);
			_object.setImplements(_implements);
			_object.setImport(_import);
			_object.setInstanceof(_instanceof);
			_object.setInt(_int);
			_object.setInterface(_interface);
			_object.setLong(_long);
			_object.setNative(_native);
			_object.setNew(_new);
			_object.setPackage(_package);
			_object.setPrivate(_private);
			_object.setProtected(_protected);
			_object.setPublic(_public);
			_object.setReturn(_return);
			_object.setShort(_short);
			_object.setStatic(_static);
			_object.setStrictfp(_strictfp);
			_object.setSuper(_super);
			_object.setSwitch(_switch);
			_object.setSynchronized(_synchronized);
			_object.setThis(_this);
			_object.setThrow(_throw);
			_object.setThrows(_throws);
			_object.setTransient(_transient);
			_object.setTry(_try);
			_object.setVoid(_void);
			_object.setVolatile(_volatile);
			_object.setWhile(_while);
			_object.set__typename("ReservedJavaKeywordAsObjectField");
			return _object;
		}
	}
}
