/** Generated by the default template from graphql-java-generator */
package com.graphql_java_generator.domain.client.allGraphQLCases;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.graphql_java_generator.client.response.AbstractCustomJacksonDeserializer;
import com.graphql_java_generator.customscalars.GraphQLScalarTypeDate;

import graphql.schema.GraphQLScalarType;

/**
 * This class is a standard Deserializer for Jackson. It uses the {@link GraphQLScalarType} that is implemented by the project for this scalar
 */
@SuppressWarnings("unused")
public class CustomJacksonDeserializers {
	
	public static class List__Field extends AbstractCustomJacksonDeserializer<List<__Field>> {
		private static final long serialVersionUID = 1L;
		public List__Field() {
			super(
				null,
true,
				__Field.class,
				null
			);
		}
	}

	public static class List__Type extends AbstractCustomJacksonDeserializer<List<__Type>> {
		private static final long serialVersionUID = 1L;
		public List__Type() {
			super(
				null,
true,
				__Type.class,
				null
			);
		}
	}

	public static class DateTime extends AbstractCustomJacksonDeserializer<java.time.OffsetDateTime> {
		private static final long serialVersionUID = 1L;
		public DateTime() {
			super(
				null,
 false,
				java.time.OffsetDateTime.class,
  				graphql.scalars.ExtendedScalars.DateTime
			);
		}
	}

	public static class NonNegativeInt extends AbstractCustomJacksonDeserializer<java.lang.Integer> {
		private static final long serialVersionUID = 1L;
		public NonNegativeInt() {
			super(
				null,
 false,
				java.lang.Integer.class,
  				graphql.scalars.ExtendedScalars.NonNegativeInt
			);
		}
	}

	public static class ListHuman extends AbstractCustomJacksonDeserializer<List<Human>> {
		private static final long serialVersionUID = 1L;
		public ListHuman() {
			super(
				null,
true,
				Human.class,
				null
			);
		}
	}

	public static class ListEpisode extends AbstractCustomJacksonDeserializer<List<Episode>> {
		private static final long serialVersionUID = 1L;
		public ListEpisode() {
			super(
				null,
true,
				Episode.class,
				null
			);
		}
	}

	public static class ListAnyCharacter extends AbstractCustomJacksonDeserializer<List<AnyCharacter>> {
		private static final long serialVersionUID = 1L;
		public ListAnyCharacter() {
			super(
				null,
true,
				AnyCharacter.class,
				null
			);
		}
	}

	public static class ListBoolean extends AbstractCustomJacksonDeserializer<List<java.lang.Boolean>> {
		private static final long serialVersionUID = 1L;
		public ListBoolean() {
			super(
				null,
true,
				java.lang.Boolean.class,
				null
			);
		}
	}

	public static class Long extends AbstractCustomJacksonDeserializer<java.lang.Long> {
		private static final long serialVersionUID = 1L;
		public Long() {
			super(
				null,
 false,
				java.lang.Long.class,
  				graphql.scalars.ExtendedScalars.GraphQLLong
			);
		}
	}

	public static class ListCharacter extends AbstractCustomJacksonDeserializer<List<Character>> {
		private static final long serialVersionUID = 1L;
		public ListCharacter() {
			super(
				null,
true,
				Character.class,
				null
			);
		}
	}

	public static class Date extends AbstractCustomJacksonDeserializer<java.util.Date> {
		private static final long serialVersionUID = 1L;
		public Date() {
			super(
				null,
 false,
				java.util.Date.class,
  				com.graphql_java_generator.customscalars.GraphQLScalarTypeDate.Date
			);
		}
	}

	public static class ListDate extends AbstractCustomJacksonDeserializer<List<java.util.Date>> {
		private static final long serialVersionUID = 1L;
		public ListDate() {
			super(
				new Date(),
true,
				java.util.Date.class,
				null
			);
		}
	}

	public static class List__EnumValue extends AbstractCustomJacksonDeserializer<List<__EnumValue>> {
		private static final long serialVersionUID = 1L;
		public List__EnumValue() {
			super(
				null,
true,
				__EnumValue.class,
				null
			);
		}
	}

	public static class ListFloat extends AbstractCustomJacksonDeserializer<List<java.lang.Double>> {
		private static final long serialVersionUID = 1L;
		public ListFloat() {
			super(
				null,
true,
				java.lang.Double.class,
				null
			);
		}
	}

	public static class ListListFloat extends AbstractCustomJacksonDeserializer<List<List<java.lang.Double>>> {
		private static final long serialVersionUID = 1L;
		public ListListFloat() {
			super(
				new ListFloat(),
true,
				java.lang.Double.class,
				null
			);
		}
	}

	public static class ListAllFieldCasesWithoutIdSubtype extends AbstractCustomJacksonDeserializer<List<AllFieldCasesWithoutIdSubtype>> {
		private static final long serialVersionUID = 1L;
		public ListAllFieldCasesWithoutIdSubtype() {
			super(
				null,
true,
				AllFieldCasesWithoutIdSubtype.class,
				null
			);
		}
	}

	public static class List__Directive extends AbstractCustomJacksonDeserializer<List<__Directive>> {
		private static final long serialVersionUID = 1L;
		public List__Directive() {
			super(
				null,
true,
				__Directive.class,
				null
			);
		}
	}

	public static class ListEnumWithReservedJavaKeywordAsValues extends AbstractCustomJacksonDeserializer<List<EnumWithReservedJavaKeywordAsValues>> {
		private static final long serialVersionUID = 1L;
		public ListEnumWithReservedJavaKeywordAsValues() {
			super(
				null,
true,
				EnumWithReservedJavaKeywordAsValues.class,
				null
			);
		}
	}

	public static class List__InputValue extends AbstractCustomJacksonDeserializer<List<__InputValue>> {
		private static final long serialVersionUID = 1L;
		public List__InputValue() {
			super(
				null,
true,
				__InputValue.class,
				null
			);
		}
	}

	public static class ListTFoo1 extends AbstractCustomJacksonDeserializer<List<TFoo1>> {
		private static final long serialVersionUID = 1L;
		public ListTFoo1() {
			super(
				null,
true,
				TFoo1.class,
				null
			);
		}
	}

	public static class ListInt extends AbstractCustomJacksonDeserializer<List<java.lang.Integer>> {
		private static final long serialVersionUID = 1L;
		public ListInt() {
			super(
				null,
true,
				java.lang.Integer.class,
				null
			);
		}
	}

	public static class ListAllFieldCasesWithIdSubtype extends AbstractCustomJacksonDeserializer<List<AllFieldCasesWithIdSubtype>> {
		private static final long serialVersionUID = 1L;
		public ListAllFieldCasesWithIdSubtype() {
			super(
				null,
true,
				AllFieldCasesWithIdSubtype.class,
				null
			);
		}
	}

	public static class List__DirectiveLocation extends AbstractCustomJacksonDeserializer<List<__DirectiveLocation>> {
		private static final long serialVersionUID = 1L;
		public List__DirectiveLocation() {
			super(
				null,
true,
				__DirectiveLocation.class,
				null
			);
		}
	}

	public static class ListString extends AbstractCustomJacksonDeserializer<List<java.lang.String>> {
		private static final long serialVersionUID = 1L;
		public ListString() {
			super(
				null,
true,
				java.lang.String.class,
				null
			);
		}
	}

	public static class ListIFoo1 extends AbstractCustomJacksonDeserializer<List<IFoo1>> {
		private static final long serialVersionUID = 1L;
		public ListIFoo1() {
			super(
				null,
true,
				IFoo1.class,
				null
			);
		}
	}

	public static class Base64String extends AbstractCustomJacksonDeserializer<byte[]> {
		private static final long serialVersionUID = 1L;

		public Base64String() {
			super(null, false, byte[].class,
					com.graphql_java_generator.customscalars.GraphQLScalarTypeBase64String.GraphQLBase64String);
		}
	}
}