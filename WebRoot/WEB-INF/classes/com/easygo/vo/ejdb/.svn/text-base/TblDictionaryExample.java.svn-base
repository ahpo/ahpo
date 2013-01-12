package com.easygo.vo.ejdb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TblDictionaryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TblDictionaryExample() {
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

        public Criteria andLookupkeyIsNull() {
            addCriterion("lookupkey is null");
            return (Criteria) this;
        }

        public Criteria andLookupkeyIsNotNull() {
            addCriterion("lookupkey is not null");
            return (Criteria) this;
        }

        public Criteria andLookupkeyEqualTo(String value) {
            addCriterion("lookupkey =", value, "lookupkey");
            return (Criteria) this;
        }

        public Criteria andLookupkeyNotEqualTo(String value) {
            addCriterion("lookupkey <>", value, "lookupkey");
            return (Criteria) this;
        }

        public Criteria andLookupkeyGreaterThan(String value) {
            addCriterion("lookupkey >", value, "lookupkey");
            return (Criteria) this;
        }

        public Criteria andLookupkeyGreaterThanOrEqualTo(String value) {
            addCriterion("lookupkey >=", value, "lookupkey");
            return (Criteria) this;
        }

        public Criteria andLookupkeyLessThan(String value) {
            addCriterion("lookupkey <", value, "lookupkey");
            return (Criteria) this;
        }

        public Criteria andLookupkeyLessThanOrEqualTo(String value) {
            addCriterion("lookupkey <=", value, "lookupkey");
            return (Criteria) this;
        }

        public Criteria andLookupkeyLike(String value) {
            addCriterion("lookupkey like", value, "lookupkey");
            return (Criteria) this;
        }

        public Criteria andLookupkeyNotLike(String value) {
            addCriterion("lookupkey not like", value, "lookupkey");
            return (Criteria) this;
        }

        public Criteria andLookupkeyIn(List<String> values) {
            addCriterion("lookupkey in", values, "lookupkey");
            return (Criteria) this;
        }

        public Criteria andLookupkeyNotIn(List<String> values) {
            addCriterion("lookupkey not in", values, "lookupkey");
            return (Criteria) this;
        }

        public Criteria andLookupkeyBetween(String value1, String value2) {
            addCriterion("lookupkey between", value1, value2, "lookupkey");
            return (Criteria) this;
        }

        public Criteria andLookupkeyNotBetween(String value1, String value2) {
            addCriterion("lookupkey not between", value1, value2, "lookupkey");
            return (Criteria) this;
        }

        public Criteria andLookupvalueIsNull() {
            addCriterion("lookupvalue is null");
            return (Criteria) this;
        }

        public Criteria andLookupvalueIsNotNull() {
            addCriterion("lookupvalue is not null");
            return (Criteria) this;
        }

        public Criteria andLookupvalueEqualTo(String value) {
            addCriterion("lookupvalue =", value, "lookupvalue");
            return (Criteria) this;
        }

        public Criteria andLookupvalueNotEqualTo(String value) {
            addCriterion("lookupvalue <>", value, "lookupvalue");
            return (Criteria) this;
        }

        public Criteria andLookupvalueGreaterThan(String value) {
            addCriterion("lookupvalue >", value, "lookupvalue");
            return (Criteria) this;
        }

        public Criteria andLookupvalueGreaterThanOrEqualTo(String value) {
            addCriterion("lookupvalue >=", value, "lookupvalue");
            return (Criteria) this;
        }

        public Criteria andLookupvalueLessThan(String value) {
            addCriterion("lookupvalue <", value, "lookupvalue");
            return (Criteria) this;
        }

        public Criteria andLookupvalueLessThanOrEqualTo(String value) {
            addCriterion("lookupvalue <=", value, "lookupvalue");
            return (Criteria) this;
        }

        public Criteria andLookupvalueLike(String value) {
            addCriterion("lookupvalue like", value, "lookupvalue");
            return (Criteria) this;
        }

        public Criteria andLookupvalueNotLike(String value) {
            addCriterion("lookupvalue not like", value, "lookupvalue");
            return (Criteria) this;
        }

        public Criteria andLookupvalueIn(List<String> values) {
            addCriterion("lookupvalue in", values, "lookupvalue");
            return (Criteria) this;
        }

        public Criteria andLookupvalueNotIn(List<String> values) {
            addCriterion("lookupvalue not in", values, "lookupvalue");
            return (Criteria) this;
        }

        public Criteria andLookupvalueBetween(String value1, String value2) {
            addCriterion("lookupvalue between", value1, value2, "lookupvalue");
            return (Criteria) this;
        }

        public Criteria andLookupvalueNotBetween(String value1, String value2) {
            addCriterion("lookupvalue not between", value1, value2, "lookupvalue");
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

        public Criteria andBackupIsNull() {
            addCriterion("backup is null");
            return (Criteria) this;
        }

        public Criteria andBackupIsNotNull() {
            addCriterion("backup is not null");
            return (Criteria) this;
        }

        public Criteria andBackupEqualTo(String value) {
            addCriterion("backup =", value, "backup");
            return (Criteria) this;
        }

        public Criteria andBackupNotEqualTo(String value) {
            addCriterion("backup <>", value, "backup");
            return (Criteria) this;
        }

        public Criteria andBackupGreaterThan(String value) {
            addCriterion("backup >", value, "backup");
            return (Criteria) this;
        }

        public Criteria andBackupGreaterThanOrEqualTo(String value) {
            addCriterion("backup >=", value, "backup");
            return (Criteria) this;
        }

        public Criteria andBackupLessThan(String value) {
            addCriterion("backup <", value, "backup");
            return (Criteria) this;
        }

        public Criteria andBackupLessThanOrEqualTo(String value) {
            addCriterion("backup <=", value, "backup");
            return (Criteria) this;
        }

        public Criteria andBackupLike(String value) {
            addCriterion("backup like", value, "backup");
            return (Criteria) this;
        }

        public Criteria andBackupNotLike(String value) {
            addCriterion("backup not like", value, "backup");
            return (Criteria) this;
        }

        public Criteria andBackupIn(List<String> values) {
            addCriterion("backup in", values, "backup");
            return (Criteria) this;
        }

        public Criteria andBackupNotIn(List<String> values) {
            addCriterion("backup not in", values, "backup");
            return (Criteria) this;
        }

        public Criteria andBackupBetween(String value1, String value2) {
            addCriterion("backup between", value1, value2, "backup");
            return (Criteria) this;
        }

        public Criteria andBackupNotBetween(String value1, String value2) {
            addCriterion("backup not between", value1, value2, "backup");
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