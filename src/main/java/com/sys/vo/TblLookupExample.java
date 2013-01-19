package com.sys.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TblLookupExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TblLookupExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andLookupNameIsNull() {
            addCriterion("lookup_name is null");
            return (Criteria) this;
        }

        public Criteria andLookupNameIsNotNull() {
            addCriterion("lookup_name is not null");
            return (Criteria) this;
        }

        public Criteria andLookupNameEqualTo(String value) {
            addCriterion("lookup_name =", value, "lookupName");
            return (Criteria) this;
        }

        public Criteria andLookupNameNotEqualTo(String value) {
            addCriterion("lookup_name <>", value, "lookupName");
            return (Criteria) this;
        }

        public Criteria andLookupNameGreaterThan(String value) {
            addCriterion("lookup_name >", value, "lookupName");
            return (Criteria) this;
        }

        public Criteria andLookupNameGreaterThanOrEqualTo(String value) {
            addCriterion("lookup_name >=", value, "lookupName");
            return (Criteria) this;
        }

        public Criteria andLookupNameLessThan(String value) {
            addCriterion("lookup_name <", value, "lookupName");
            return (Criteria) this;
        }

        public Criteria andLookupNameLessThanOrEqualTo(String value) {
            addCriterion("lookup_name <=", value, "lookupName");
            return (Criteria) this;
        }

        public Criteria andLookupNameLike(String value) {
            addCriterion("lookup_name like", value, "lookupName");
            return (Criteria) this;
        }

        public Criteria andLookupNameNotLike(String value) {
            addCriterion("lookup_name not like", value, "lookupName");
            return (Criteria) this;
        }

        public Criteria andLookupNameIn(List<String> values) {
            addCriterion("lookup_name in", values, "lookupName");
            return (Criteria) this;
        }

        public Criteria andLookupNameNotIn(List<String> values) {
            addCriterion("lookup_name not in", values, "lookupName");
            return (Criteria) this;
        }

        public Criteria andLookupNameBetween(String value1, String value2) {
            addCriterion("lookup_name between", value1, value2, "lookupName");
            return (Criteria) this;
        }

        public Criteria andLookupNameNotBetween(String value1, String value2) {
            addCriterion("lookup_name not between", value1, value2, "lookupName");
            return (Criteria) this;
        }

        public Criteria andLookupKeyIsNull() {
            addCriterion("lookup_key is null");
            return (Criteria) this;
        }

        public Criteria andLookupKeyIsNotNull() {
            addCriterion("lookup_key is not null");
            return (Criteria) this;
        }

        public Criteria andLookupKeyEqualTo(String value) {
            addCriterion("lookup_key =", value, "lookupKey");
            return (Criteria) this;
        }

        public Criteria andLookupKeyNotEqualTo(String value) {
            addCriterion("lookup_key <>", value, "lookupKey");
            return (Criteria) this;
        }

        public Criteria andLookupKeyGreaterThan(String value) {
            addCriterion("lookup_key >", value, "lookupKey");
            return (Criteria) this;
        }

        public Criteria andLookupKeyGreaterThanOrEqualTo(String value) {
            addCriterion("lookup_key >=", value, "lookupKey");
            return (Criteria) this;
        }

        public Criteria andLookupKeyLessThan(String value) {
            addCriterion("lookup_key <", value, "lookupKey");
            return (Criteria) this;
        }

        public Criteria andLookupKeyLessThanOrEqualTo(String value) {
            addCriterion("lookup_key <=", value, "lookupKey");
            return (Criteria) this;
        }

        public Criteria andLookupKeyLike(String value) {
            addCriterion("lookup_key like", value, "lookupKey");
            return (Criteria) this;
        }

        public Criteria andLookupKeyNotLike(String value) {
            addCriterion("lookup_key not like", value, "lookupKey");
            return (Criteria) this;
        }

        public Criteria andLookupKeyIn(List<String> values) {
            addCriterion("lookup_key in", values, "lookupKey");
            return (Criteria) this;
        }

        public Criteria andLookupKeyNotIn(List<String> values) {
            addCriterion("lookup_key not in", values, "lookupKey");
            return (Criteria) this;
        }

        public Criteria andLookupKeyBetween(String value1, String value2) {
            addCriterion("lookup_key between", value1, value2, "lookupKey");
            return (Criteria) this;
        }

        public Criteria andLookupKeyNotBetween(String value1, String value2) {
            addCriterion("lookup_key not between", value1, value2, "lookupKey");
            return (Criteria) this;
        }

        public Criteria andLookupValueIsNull() {
            addCriterion("lookup_value is null");
            return (Criteria) this;
        }

        public Criteria andLookupValueIsNotNull() {
            addCriterion("lookup_value is not null");
            return (Criteria) this;
        }

        public Criteria andLookupValueEqualTo(String value) {
            addCriterion("lookup_value =", value, "lookupValue");
            return (Criteria) this;
        }

        public Criteria andLookupValueNotEqualTo(String value) {
            addCriterion("lookup_value <>", value, "lookupValue");
            return (Criteria) this;
        }

        public Criteria andLookupValueGreaterThan(String value) {
            addCriterion("lookup_value >", value, "lookupValue");
            return (Criteria) this;
        }

        public Criteria andLookupValueGreaterThanOrEqualTo(String value) {
            addCriterion("lookup_value >=", value, "lookupValue");
            return (Criteria) this;
        }

        public Criteria andLookupValueLessThan(String value) {
            addCriterion("lookup_value <", value, "lookupValue");
            return (Criteria) this;
        }

        public Criteria andLookupValueLessThanOrEqualTo(String value) {
            addCriterion("lookup_value <=", value, "lookupValue");
            return (Criteria) this;
        }

        public Criteria andLookupValueLike(String value) {
            addCriterion("lookup_value like", value, "lookupValue");
            return (Criteria) this;
        }

        public Criteria andLookupValueNotLike(String value) {
            addCriterion("lookup_value not like", value, "lookupValue");
            return (Criteria) this;
        }

        public Criteria andLookupValueIn(List<String> values) {
            addCriterion("lookup_value in", values, "lookupValue");
            return (Criteria) this;
        }

        public Criteria andLookupValueNotIn(List<String> values) {
            addCriterion("lookup_value not in", values, "lookupValue");
            return (Criteria) this;
        }

        public Criteria andLookupValueBetween(String value1, String value2) {
            addCriterion("lookup_value between", value1, value2, "lookupValue");
            return (Criteria) this;
        }

        public Criteria andLookupValueNotBetween(String value1, String value2) {
            addCriterion("lookup_value not between", value1, value2, "lookupValue");
            return (Criteria) this;
        }

        public Criteria andDescribeinfoIsNull() {
            addCriterion("describeinfo is null");
            return (Criteria) this;
        }

        public Criteria andDescribeinfoIsNotNull() {
            addCriterion("describeinfo is not null");
            return (Criteria) this;
        }

        public Criteria andDescribeinfoEqualTo(String value) {
            addCriterion("describeinfo =", value, "describeinfo");
            return (Criteria) this;
        }

        public Criteria andDescribeinfoNotEqualTo(String value) {
            addCriterion("describeinfo <>", value, "describeinfo");
            return (Criteria) this;
        }

        public Criteria andDescribeinfoGreaterThan(String value) {
            addCriterion("describeinfo >", value, "describeinfo");
            return (Criteria) this;
        }

        public Criteria andDescribeinfoGreaterThanOrEqualTo(String value) {
            addCriterion("describeinfo >=", value, "describeinfo");
            return (Criteria) this;
        }

        public Criteria andDescribeinfoLessThan(String value) {
            addCriterion("describeinfo <", value, "describeinfo");
            return (Criteria) this;
        }

        public Criteria andDescribeinfoLessThanOrEqualTo(String value) {
            addCriterion("describeinfo <=", value, "describeinfo");
            return (Criteria) this;
        }

        public Criteria andDescribeinfoLike(String value) {
            addCriterion("describeinfo like", value, "describeinfo");
            return (Criteria) this;
        }

        public Criteria andDescribeinfoNotLike(String value) {
            addCriterion("describeinfo not like", value, "describeinfo");
            return (Criteria) this;
        }

        public Criteria andDescribeinfoIn(List<String> values) {
            addCriterion("describeinfo in", values, "describeinfo");
            return (Criteria) this;
        }

        public Criteria andDescribeinfoNotIn(List<String> values) {
            addCriterion("describeinfo not in", values, "describeinfo");
            return (Criteria) this;
        }

        public Criteria andDescribeinfoBetween(String value1, String value2) {
            addCriterion("describeinfo between", value1, value2, "describeinfo");
            return (Criteria) this;
        }

        public Criteria andDescribeinfoNotBetween(String value1, String value2) {
            addCriterion("describeinfo not between", value1, value2, "describeinfo");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updatetime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("updatetime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("updatetime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("updatetime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updatetime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("updatetime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("updatetime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("updatetime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("updatetime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("updatetime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("updatetime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}