package com.sys.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysLogExample() {
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

        public Criteria andLogidIsNull() {
            addCriterion("LOGID is null");
            return (Criteria) this;
        }

        public Criteria andLogidIsNotNull() {
            addCriterion("LOGID is not null");
            return (Criteria) this;
        }

        public Criteria andLogidEqualTo(Integer value) {
            addCriterion("LOGID =", value, "logid");
            return (Criteria) this;
        }

        public Criteria andLogidNotEqualTo(Integer value) {
            addCriterion("LOGID <>", value, "logid");
            return (Criteria) this;
        }

        public Criteria andLogidGreaterThan(Integer value) {
            addCriterion("LOGID >", value, "logid");
            return (Criteria) this;
        }

        public Criteria andLogidGreaterThanOrEqualTo(Integer value) {
            addCriterion("LOGID >=", value, "logid");
            return (Criteria) this;
        }

        public Criteria andLogidLessThan(Integer value) {
            addCriterion("LOGID <", value, "logid");
            return (Criteria) this;
        }

        public Criteria andLogidLessThanOrEqualTo(Integer value) {
            addCriterion("LOGID <=", value, "logid");
            return (Criteria) this;
        }

        public Criteria andLogidIn(List<Integer> values) {
            addCriterion("LOGID in", values, "logid");
            return (Criteria) this;
        }

        public Criteria andLogidNotIn(List<Integer> values) {
            addCriterion("LOGID not in", values, "logid");
            return (Criteria) this;
        }

        public Criteria andLogidBetween(Integer value1, Integer value2) {
            addCriterion("LOGID between", value1, value2, "logid");
            return (Criteria) this;
        }

        public Criteria andLogidNotBetween(Integer value1, Integer value2) {
            addCriterion("LOGID not between", value1, value2, "logid");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("UID is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("UID is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Integer value) {
            addCriterion("UID =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Integer value) {
            addCriterion("UID <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Integer value) {
            addCriterion("UID >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("UID >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Integer value) {
            addCriterion("UID <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Integer value) {
            addCriterion("UID <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Integer> values) {
            addCriterion("UID in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Integer> values) {
            addCriterion("UID not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Integer value1, Integer value2) {
            addCriterion("UID between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Integer value1, Integer value2) {
            addCriterion("UID not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andLtypeIsNull() {
            addCriterion("LTYPE is null");
            return (Criteria) this;
        }

        public Criteria andLtypeIsNotNull() {
            addCriterion("LTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andLtypeEqualTo(String value) {
            addCriterion("LTYPE =", value, "ltype");
            return (Criteria) this;
        }

        public Criteria andLtypeNotEqualTo(String value) {
            addCriterion("LTYPE <>", value, "ltype");
            return (Criteria) this;
        }

        public Criteria andLtypeGreaterThan(String value) {
            addCriterion("LTYPE >", value, "ltype");
            return (Criteria) this;
        }

        public Criteria andLtypeGreaterThanOrEqualTo(String value) {
            addCriterion("LTYPE >=", value, "ltype");
            return (Criteria) this;
        }

        public Criteria andLtypeLessThan(String value) {
            addCriterion("LTYPE <", value, "ltype");
            return (Criteria) this;
        }

        public Criteria andLtypeLessThanOrEqualTo(String value) {
            addCriterion("LTYPE <=", value, "ltype");
            return (Criteria) this;
        }

        public Criteria andLtypeLike(String value) {
            addCriterion("LTYPE like", value, "ltype");
            return (Criteria) this;
        }

        public Criteria andLtypeNotLike(String value) {
            addCriterion("LTYPE not like", value, "ltype");
            return (Criteria) this;
        }

        public Criteria andLtypeIn(List<String> values) {
            addCriterion("LTYPE in", values, "ltype");
            return (Criteria) this;
        }

        public Criteria andLtypeNotIn(List<String> values) {
            addCriterion("LTYPE not in", values, "ltype");
            return (Criteria) this;
        }

        public Criteria andLtypeBetween(String value1, String value2) {
            addCriterion("LTYPE between", value1, value2, "ltype");
            return (Criteria) this;
        }

        public Criteria andLtypeNotBetween(String value1, String value2) {
            addCriterion("LTYPE not between", value1, value2, "ltype");
            return (Criteria) this;
        }

        public Criteria andMemoIsNull() {
            addCriterion("MEMO is null");
            return (Criteria) this;
        }

        public Criteria andMemoIsNotNull() {
            addCriterion("MEMO is not null");
            return (Criteria) this;
        }

        public Criteria andMemoEqualTo(String value) {
            addCriterion("MEMO =", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotEqualTo(String value) {
            addCriterion("MEMO <>", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThan(String value) {
            addCriterion("MEMO >", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThanOrEqualTo(String value) {
            addCriterion("MEMO >=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThan(String value) {
            addCriterion("MEMO <", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThanOrEqualTo(String value) {
            addCriterion("MEMO <=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLike(String value) {
            addCriterion("MEMO like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotLike(String value) {
            addCriterion("MEMO not like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoIn(List<String> values) {
            addCriterion("MEMO in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotIn(List<String> values) {
            addCriterion("MEMO not in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoBetween(String value1, String value2) {
            addCriterion("MEMO between", value1, value2, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotBetween(String value1, String value2) {
            addCriterion("MEMO not between", value1, value2, "memo");
            return (Criteria) this;
        }

        public Criteria andLogDateIsNull() {
            addCriterion("LOG_DATE is null");
            return (Criteria) this;
        }

        public Criteria andLogDateIsNotNull() {
            addCriterion("LOG_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andLogDateEqualTo(Date value) {
            addCriterion("LOG_DATE =", value, "logDate");
            return (Criteria) this;
        }

        public Criteria andLogDateNotEqualTo(Date value) {
            addCriterion("LOG_DATE <>", value, "logDate");
            return (Criteria) this;
        }

        public Criteria andLogDateGreaterThan(Date value) {
            addCriterion("LOG_DATE >", value, "logDate");
            return (Criteria) this;
        }

        public Criteria andLogDateGreaterThanOrEqualTo(Date value) {
            addCriterion("LOG_DATE >=", value, "logDate");
            return (Criteria) this;
        }

        public Criteria andLogDateLessThan(Date value) {
            addCriterion("LOG_DATE <", value, "logDate");
            return (Criteria) this;
        }

        public Criteria andLogDateLessThanOrEqualTo(Date value) {
            addCriterion("LOG_DATE <=", value, "logDate");
            return (Criteria) this;
        }

        public Criteria andLogDateIn(List<Date> values) {
            addCriterion("LOG_DATE in", values, "logDate");
            return (Criteria) this;
        }

        public Criteria andLogDateNotIn(List<Date> values) {
            addCriterion("LOG_DATE not in", values, "logDate");
            return (Criteria) this;
        }

        public Criteria andLogDateBetween(Date value1, Date value2) {
            addCriterion("LOG_DATE between", value1, value2, "logDate");
            return (Criteria) this;
        }

        public Criteria andLogDateNotBetween(Date value1, Date value2) {
            addCriterion("LOG_DATE not between", value1, value2, "logDate");
            return (Criteria) this;
        }

        public Criteria andUserIpIsNull() {
            addCriterion("USER_IP is null");
            return (Criteria) this;
        }

        public Criteria andUserIpIsNotNull() {
            addCriterion("USER_IP is not null");
            return (Criteria) this;
        }

        public Criteria andUserIpEqualTo(String value) {
            addCriterion("USER_IP =", value, "userIp");
            return (Criteria) this;
        }

        public Criteria andUserIpNotEqualTo(String value) {
            addCriterion("USER_IP <>", value, "userIp");
            return (Criteria) this;
        }

        public Criteria andUserIpGreaterThan(String value) {
            addCriterion("USER_IP >", value, "userIp");
            return (Criteria) this;
        }

        public Criteria andUserIpGreaterThanOrEqualTo(String value) {
            addCriterion("USER_IP >=", value, "userIp");
            return (Criteria) this;
        }

        public Criteria andUserIpLessThan(String value) {
            addCriterion("USER_IP <", value, "userIp");
            return (Criteria) this;
        }

        public Criteria andUserIpLessThanOrEqualTo(String value) {
            addCriterion("USER_IP <=", value, "userIp");
            return (Criteria) this;
        }

        public Criteria andUserIpLike(String value) {
            addCriterion("USER_IP like", value, "userIp");
            return (Criteria) this;
        }

        public Criteria andUserIpNotLike(String value) {
            addCriterion("USER_IP not like", value, "userIp");
            return (Criteria) this;
        }

        public Criteria andUserIpIn(List<String> values) {
            addCriterion("USER_IP in", values, "userIp");
            return (Criteria) this;
        }

        public Criteria andUserIpNotIn(List<String> values) {
            addCriterion("USER_IP not in", values, "userIp");
            return (Criteria) this;
        }

        public Criteria andUserIpBetween(String value1, String value2) {
            addCriterion("USER_IP between", value1, value2, "userIp");
            return (Criteria) this;
        }

        public Criteria andUserIpNotBetween(String value1, String value2) {
            addCriterion("USER_IP not between", value1, value2, "userIp");
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