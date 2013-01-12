package com.sys.vo;

import java.util.ArrayList;
import java.util.List;

public class SysResourceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysResourceExample() {
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

        public Criteria andResidIsNull() {
            addCriterion("RESID is null");
            return (Criteria) this;
        }

        public Criteria andResidIsNotNull() {
            addCriterion("RESID is not null");
            return (Criteria) this;
        }

        public Criteria andResidEqualTo(Integer value) {
            addCriterion("RESID =", value, "resid");
            return (Criteria) this;
        }

        public Criteria andResidNotEqualTo(Integer value) {
            addCriterion("RESID <>", value, "resid");
            return (Criteria) this;
        }

        public Criteria andResidGreaterThan(Integer value) {
            addCriterion("RESID >", value, "resid");
            return (Criteria) this;
        }

        public Criteria andResidGreaterThanOrEqualTo(Integer value) {
            addCriterion("RESID >=", value, "resid");
            return (Criteria) this;
        }

        public Criteria andResidLessThan(Integer value) {
            addCriterion("RESID <", value, "resid");
            return (Criteria) this;
        }

        public Criteria andResidLessThanOrEqualTo(Integer value) {
            addCriterion("RESID <=", value, "resid");
            return (Criteria) this;
        }

        public Criteria andResidIn(List<Integer> values) {
            addCriterion("RESID in", values, "resid");
            return (Criteria) this;
        }

        public Criteria andResidNotIn(List<Integer> values) {
            addCriterion("RESID not in", values, "resid");
            return (Criteria) this;
        }

        public Criteria andResidBetween(Integer value1, Integer value2) {
            addCriterion("RESID between", value1, value2, "resid");
            return (Criteria) this;
        }

        public Criteria andResidNotBetween(Integer value1, Integer value2) {
            addCriterion("RESID not between", value1, value2, "resid");
            return (Criteria) this;
        }

        public Criteria andResNameIsNull() {
            addCriterion("RES_NAME is null");
            return (Criteria) this;
        }

        public Criteria andResNameIsNotNull() {
            addCriterion("RES_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andResNameEqualTo(String value) {
            addCriterion("RES_NAME =", value, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameNotEqualTo(String value) {
            addCriterion("RES_NAME <>", value, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameGreaterThan(String value) {
            addCriterion("RES_NAME >", value, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameGreaterThanOrEqualTo(String value) {
            addCriterion("RES_NAME >=", value, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameLessThan(String value) {
            addCriterion("RES_NAME <", value, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameLessThanOrEqualTo(String value) {
            addCriterion("RES_NAME <=", value, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameLike(String value) {
            addCriterion("RES_NAME like", value, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameNotLike(String value) {
            addCriterion("RES_NAME not like", value, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameIn(List<String> values) {
            addCriterion("RES_NAME in", values, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameNotIn(List<String> values) {
            addCriterion("RES_NAME not in", values, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameBetween(String value1, String value2) {
            addCriterion("RES_NAME between", value1, value2, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameNotBetween(String value1, String value2) {
            addCriterion("RES_NAME not between", value1, value2, "resName");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("URL is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("URL is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("URL =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("URL <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("URL >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("URL >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("URL <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("URL <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("URL like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("URL not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("URL in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("URL not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("URL between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("URL not between", value1, value2, "url");
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

        public Criteria andPrioIsNull() {
            addCriterion("PRIO is null");
            return (Criteria) this;
        }

        public Criteria andPrioIsNotNull() {
            addCriterion("PRIO is not null");
            return (Criteria) this;
        }

        public Criteria andPrioEqualTo(Integer value) {
            addCriterion("PRIO =", value, "prio");
            return (Criteria) this;
        }

        public Criteria andPrioNotEqualTo(Integer value) {
            addCriterion("PRIO <>", value, "prio");
            return (Criteria) this;
        }

        public Criteria andPrioGreaterThan(Integer value) {
            addCriterion("PRIO >", value, "prio");
            return (Criteria) this;
        }

        public Criteria andPrioGreaterThanOrEqualTo(Integer value) {
            addCriterion("PRIO >=", value, "prio");
            return (Criteria) this;
        }

        public Criteria andPrioLessThan(Integer value) {
            addCriterion("PRIO <", value, "prio");
            return (Criteria) this;
        }

        public Criteria andPrioLessThanOrEqualTo(Integer value) {
            addCriterion("PRIO <=", value, "prio");
            return (Criteria) this;
        }

        public Criteria andPrioIn(List<Integer> values) {
            addCriterion("PRIO in", values, "prio");
            return (Criteria) this;
        }

        public Criteria andPrioNotIn(List<Integer> values) {
            addCriterion("PRIO not in", values, "prio");
            return (Criteria) this;
        }

        public Criteria andPrioBetween(Integer value1, Integer value2) {
            addCriterion("PRIO between", value1, value2, "prio");
            return (Criteria) this;
        }

        public Criteria andPrioNotBetween(Integer value1, Integer value2) {
            addCriterion("PRIO not between", value1, value2, "prio");
            return (Criteria) this;
        }

        public Criteria andRtypeIsNull() {
            addCriterion("RTYPE is null");
            return (Criteria) this;
        }

        public Criteria andRtypeIsNotNull() {
            addCriterion("RTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andRtypeEqualTo(String value) {
            addCriterion("RTYPE =", value, "rtype");
            return (Criteria) this;
        }

        public Criteria andRtypeNotEqualTo(String value) {
            addCriterion("RTYPE <>", value, "rtype");
            return (Criteria) this;
        }

        public Criteria andRtypeGreaterThan(String value) {
            addCriterion("RTYPE >", value, "rtype");
            return (Criteria) this;
        }

        public Criteria andRtypeGreaterThanOrEqualTo(String value) {
            addCriterion("RTYPE >=", value, "rtype");
            return (Criteria) this;
        }

        public Criteria andRtypeLessThan(String value) {
            addCriterion("RTYPE <", value, "rtype");
            return (Criteria) this;
        }

        public Criteria andRtypeLessThanOrEqualTo(String value) {
            addCriterion("RTYPE <=", value, "rtype");
            return (Criteria) this;
        }

        public Criteria andRtypeLike(String value) {
            addCriterion("RTYPE like", value, "rtype");
            return (Criteria) this;
        }

        public Criteria andRtypeNotLike(String value) {
            addCriterion("RTYPE not like", value, "rtype");
            return (Criteria) this;
        }

        public Criteria andRtypeIn(List<String> values) {
            addCriterion("RTYPE in", values, "rtype");
            return (Criteria) this;
        }

        public Criteria andRtypeNotIn(List<String> values) {
            addCriterion("RTYPE not in", values, "rtype");
            return (Criteria) this;
        }

        public Criteria andRtypeBetween(String value1, String value2) {
            addCriterion("RTYPE between", value1, value2, "rtype");
            return (Criteria) this;
        }

        public Criteria andRtypeNotBetween(String value1, String value2) {
            addCriterion("RTYPE not between", value1, value2, "rtype");
            return (Criteria) this;
        }

        public Criteria andIsParentIsNull() {
            addCriterion("IS_PARENT is null");
            return (Criteria) this;
        }

        public Criteria andIsParentIsNotNull() {
            addCriterion("IS_PARENT is not null");
            return (Criteria) this;
        }

        public Criteria andIsParentEqualTo(String value) {
            addCriterion("IS_PARENT =", value, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentNotEqualTo(String value) {
            addCriterion("IS_PARENT <>", value, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentGreaterThan(String value) {
            addCriterion("IS_PARENT >", value, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentGreaterThanOrEqualTo(String value) {
            addCriterion("IS_PARENT >=", value, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentLessThan(String value) {
            addCriterion("IS_PARENT <", value, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentLessThanOrEqualTo(String value) {
            addCriterion("IS_PARENT <=", value, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentLike(String value) {
            addCriterion("IS_PARENT like", value, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentNotLike(String value) {
            addCriterion("IS_PARENT not like", value, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentIn(List<String> values) {
            addCriterion("IS_PARENT in", values, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentNotIn(List<String> values) {
            addCriterion("IS_PARENT not in", values, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentBetween(String value1, String value2) {
            addCriterion("IS_PARENT between", value1, value2, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentNotBetween(String value1, String value2) {
            addCriterion("IS_PARENT not between", value1, value2, "isParent");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("PARENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("PARENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(Integer value) {
            addCriterion("PARENT_ID =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(Integer value) {
            addCriterion("PARENT_ID <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(Integer value) {
            addCriterion("PARENT_ID >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("PARENT_ID >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(Integer value) {
            addCriterion("PARENT_ID <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(Integer value) {
            addCriterion("PARENT_ID <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<Integer> values) {
            addCriterion("PARENT_ID in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<Integer> values) {
            addCriterion("PARENT_ID not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(Integer value1, Integer value2) {
            addCriterion("PARENT_ID between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("PARENT_ID not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andResLevelIsNull() {
            addCriterion("RES_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andResLevelIsNotNull() {
            addCriterion("RES_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andResLevelEqualTo(Integer value) {
            addCriterion("RES_LEVEL =", value, "resLevel");
            return (Criteria) this;
        }

        public Criteria andResLevelNotEqualTo(Integer value) {
            addCriterion("RES_LEVEL <>", value, "resLevel");
            return (Criteria) this;
        }

        public Criteria andResLevelGreaterThan(Integer value) {
            addCriterion("RES_LEVEL >", value, "resLevel");
            return (Criteria) this;
        }

        public Criteria andResLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("RES_LEVEL >=", value, "resLevel");
            return (Criteria) this;
        }

        public Criteria andResLevelLessThan(Integer value) {
            addCriterion("RES_LEVEL <", value, "resLevel");
            return (Criteria) this;
        }

        public Criteria andResLevelLessThanOrEqualTo(Integer value) {
            addCriterion("RES_LEVEL <=", value, "resLevel");
            return (Criteria) this;
        }

        public Criteria andResLevelIn(List<Integer> values) {
            addCriterion("RES_LEVEL in", values, "resLevel");
            return (Criteria) this;
        }

        public Criteria andResLevelNotIn(List<Integer> values) {
            addCriterion("RES_LEVEL not in", values, "resLevel");
            return (Criteria) this;
        }

        public Criteria andResLevelBetween(Integer value1, Integer value2) {
            addCriterion("RES_LEVEL between", value1, value2, "resLevel");
            return (Criteria) this;
        }

        public Criteria andResLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("RES_LEVEL not between", value1, value2, "resLevel");
            return (Criteria) this;
        }

        public Criteria andResCodeIsNull() {
            addCriterion("RES_CODE is null");
            return (Criteria) this;
        }

        public Criteria andResCodeIsNotNull() {
            addCriterion("RES_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andResCodeEqualTo(String value) {
            addCriterion("RES_CODE =", value, "resCode");
            return (Criteria) this;
        }

        public Criteria andResCodeNotEqualTo(String value) {
            addCriterion("RES_CODE <>", value, "resCode");
            return (Criteria) this;
        }

        public Criteria andResCodeGreaterThan(String value) {
            addCriterion("RES_CODE >", value, "resCode");
            return (Criteria) this;
        }

        public Criteria andResCodeGreaterThanOrEqualTo(String value) {
            addCriterion("RES_CODE >=", value, "resCode");
            return (Criteria) this;
        }

        public Criteria andResCodeLessThan(String value) {
            addCriterion("RES_CODE <", value, "resCode");
            return (Criteria) this;
        }

        public Criteria andResCodeLessThanOrEqualTo(String value) {
            addCriterion("RES_CODE <=", value, "resCode");
            return (Criteria) this;
        }

        public Criteria andResCodeLike(String value) {
            addCriterion("RES_CODE like", value, "resCode");
            return (Criteria) this;
        }

        public Criteria andResCodeNotLike(String value) {
            addCriterion("RES_CODE not like", value, "resCode");
            return (Criteria) this;
        }

        public Criteria andResCodeIn(List<String> values) {
            addCriterion("RES_CODE in", values, "resCode");
            return (Criteria) this;
        }

        public Criteria andResCodeNotIn(List<String> values) {
            addCriterion("RES_CODE not in", values, "resCode");
            return (Criteria) this;
        }

        public Criteria andResCodeBetween(String value1, String value2) {
            addCriterion("RES_CODE between", value1, value2, "resCode");
            return (Criteria) this;
        }

        public Criteria andResCodeNotBetween(String value1, String value2) {
            addCriterion("RES_CODE not between", value1, value2, "resCode");
            return (Criteria) this;
        }

        public Criteria andImgUrlIsNull() {
            addCriterion("IMG_URL is null");
            return (Criteria) this;
        }

        public Criteria andImgUrlIsNotNull() {
            addCriterion("IMG_URL is not null");
            return (Criteria) this;
        }

        public Criteria andImgUrlEqualTo(String value) {
            addCriterion("IMG_URL =", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotEqualTo(String value) {
            addCriterion("IMG_URL <>", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlGreaterThan(String value) {
            addCriterion("IMG_URL >", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("IMG_URL >=", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLessThan(String value) {
            addCriterion("IMG_URL <", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLessThanOrEqualTo(String value) {
            addCriterion("IMG_URL <=", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLike(String value) {
            addCriterion("IMG_URL like", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotLike(String value) {
            addCriterion("IMG_URL not like", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlIn(List<String> values) {
            addCriterion("IMG_URL in", values, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotIn(List<String> values) {
            addCriterion("IMG_URL not in", values, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlBetween(String value1, String value2) {
            addCriterion("IMG_URL between", value1, value2, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotBetween(String value1, String value2) {
            addCriterion("IMG_URL not between", value1, value2, "imgUrl");
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