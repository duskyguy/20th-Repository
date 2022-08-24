/** Generated by the default template from graphql-java-generator */
package com.graphql_java_generator.domain.server.allGraphQLCases;

import java.util.HashMap;
import java.util.Map;


import com.graphql_java_generator.annotation.GraphQLNonScalar;
import com.graphql_java_generator.annotation.GraphQLObjectType;
import java.util.List;



/**
 *
 * @author generated by graphql-java-generator
 * @see <a href="https://github.com/graphql-java-generator/graphql-java-generator">https://github.com/graphql-java-generator/graphql-java-generator</a>
 */

@GraphQLObjectType("TList")
@SuppressWarnings("unused")
public class TList 
	implements IList{


	public TList(){
		// No action
	}

	
	@GraphQLNonScalar(fieldName = "list", graphQLTypeSimpleName = "TFoo1", javaClass = TFoo1.class)
	List<TFoo1> list;




	/**
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void setList(List<IFoo1> list) {
		if (list == null || list instanceof List) {
			// list is an instance of List<IFoo1>. Let's check that this can be copied into a List<TFoo1> 
			for (Object item : list) {
				if (! (item instanceof TFoo1))
					throw new IllegalArgumentException("The given list should be a list of instances of TFoo1, but at least one item is an instance of "
							+ item.getClass().getName());
			}
			this.list = (List<TFoo1>) (Object) list;
		} else {
			throw new IllegalArgumentException("The given list should be an instance of List<TFoo1>, but is an instance of "
					+ list.getClass().getName());
		}
	}
 

	/** 
	 * As the type declared in the class is not inherited from one of the implemented interfaces, we need a dedicated setter.
	 * <br/>
	 * As the GraphQL type of this field is a list of items that are not of the same type as the field defined in the implemented interface, 
	 * we need to have a dedicated setter with a specific name. This is due to Java that does type erasure on parameterized types (for 
	 * compatibility reasons with older java versions). As Java can't detect at runtime the type of the items of the list, it can't 
	 * decide which setter to call. To overcome this issue, this setter has a dedicated name.
	 * 
	 * @param
	 */
	public void setListTFoo1(List<TFoo1> list) {
		this.list = list;
	}

 	/**
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<IFoo1> getList() {
		return (List<IFoo1>) (Object) list;
	}

	/**
	 */
	public List<TFoo1> getListTFoo1() {
		return list;
	}

     public String toString() {
        return "TList {"
				+ "list: " + list
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
		private List<TFoo1> list;

		public Builder withList(List<TFoo1> list) {
			this.list = list;
			return this;
		}

		public TList build() {
			TList _object = new TList();
			_object.setListTFoo1(list);
			return _object;
		}
	}
}
