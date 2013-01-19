package com.sys.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysTaskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysTaskExample() {
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

        public Criteria andTaskIdIsNull() {
            addCriterion("task_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("task_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(Integer value) {
            addCriterion("task_id =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(Integer value) {
            addCriterion("task_id <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(Integer value) {
            addCriterion("task_id >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_id >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(Integer value) {
            addCriterion("task_id <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(Integer value) {
            addCriterion("task_id <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<Integer> values) {
            addCriterion("task_id in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<Integer> values) {
            addCriterion("task_id not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(Integer value1, Integer value2) {
            addCriterion("task_id between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(Integer value1, Integer value2) {
            addCriterion("task_id not between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskNameIsNull() {
            addCriterion("task_name is null");
            return (Criteria) this;
        }

        public Criteria andTaskNameIsNotNull() {
            addCriterion("task_name is not null");
            return (Criteria) this;
        }

        public Criteria andTaskNameEqualTo(String value) {
            addCriterion("task_name =", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotEqualTo(String value) {
            addCriterion("task_name <>", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThan(String value) {
            addCriterion("task_name >", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThanOrEqualTo(String value) {
            addCriterion("task_name >=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThan(String value) {
            addCriterion("task_name <", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThanOrEqualTo(String value) {
            addCriterion("task_name <=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLike(String value) {
            addCriterion("task_name like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotLike(String value) {
            addCriterion("task_name not like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameIn(List<String> values) {
            addCriterion("task_name in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotIn(List<String> values) {
            addCriterion("task_name not in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameBetween(String value1, String value2) {
            addCriterion("task_name between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotBetween(String value1, String value2) {
            addCriterion("task_name not between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskClassIsNull() {
            addCriterion("task_class is null");
            return (Criteria) this;
        }

        public Criteria andTaskClassIsNotNull() {
            addCriterion("task_class is not null");
            return (Criteria) this;
        }

        public Criteria andTaskClassEqualTo(String value) {
            addCriterion("task_class =", value, "taskClass");
            return (Criteria) this;
        }

        public Criteria andTaskClassNotEqualTo(String value) {
            addCriterion("task_class <>", value, "taskClass");
            return (Criteria) this;
        }

        public Criteria andTaskClassGreaterThan(String value) {
            addCriterion("task_class >", value, "taskClass");
            return (Criteria) this;
        }

        public Criteria andTaskClassGreaterThanOrEqualTo(String value) {
            addCriterion("task_class >=", value, "taskClass");
            return (Criteria) this;
        }

        public Criteria andTaskClassLessThan(String value) {
            addCriterion("task_class <", value, "taskClass");
            return (Criteria) this;
        }

        public Criteria andTaskClassLessThanOrEqualTo(String value) {
            addCriterion("task_class <=", value, "taskClass");
            return (Criteria) this;
        }

        public Criteria andTaskClassLike(String value) {
            addCriterion("task_class like", value, "taskClass");
            return (Criteria) this;
        }

        public Criteria andTaskClassNotLike(String value) {
            addCriterion("task_class not like", value, "taskClass");
            return (Criteria) this;
        }

        public Criteria andTaskClassIn(List<String> values) {
            addCriterion("task_class in", values, "taskClass");
            return (Criteria) this;
        }

        public Criteria andTaskClassNotIn(List<String> values) {
            addCriterion("task_class not in", values, "taskClass");
            return (Criteria) this;
        }

        public Criteria andTaskClassBetween(String value1, String value2) {
            addCriterion("task_class between", value1, value2, "taskClass");
            return (Criteria) this;
        }

        public Criteria andTaskClassNotBetween(String value1, String value2) {
            addCriterion("task_class not between", value1, value2, "taskClass");
            return (Criteria) this;
        }

        public Criteria andTaskMethodIsNull() {
            addCriterion("task_method is null");
            return (Criteria) this;
        }

        public Criteria andTaskMethodIsNotNull() {
            addCriterion("task_method is not null");
            return (Criteria) this;
        }

        public Criteria andTaskMethodEqualTo(String value) {
            addCriterion("task_method =", value, "taskMethod");
            return (Criteria) this;
        }

        public Criteria andTaskMethodNotEqualTo(String value) {
            addCriterion("task_method <>", value, "taskMethod");
            return (Criteria) this;
        }

        public Criteria andTaskMethodGreaterThan(String value) {
            addCriterion("task_method >", value, "taskMethod");
            return (Criteria) this;
        }

        public Criteria andTaskMethodGreaterThanOrEqualTo(String value) {
            addCriterion("task_method >=", value, "taskMethod");
            return (Criteria) this;
        }

        public Criteria andTaskMethodLessThan(String value) {
            addCriterion("task_method <", value, "taskMethod");
            return (Criteria) this;
        }

        public Criteria andTaskMethodLessThanOrEqualTo(String value) {
            addCriterion("task_method <=", value, "taskMethod");
            return (Criteria) this;
        }

        public Criteria andTaskMethodLike(String value) {
            addCriterion("task_method like", value, "taskMethod");
            return (Criteria) this;
        }

        public Criteria andTaskMethodNotLike(String value) {
            addCriterion("task_method not like", value, "taskMethod");
            return (Criteria) this;
        }

        public Criteria andTaskMethodIn(List<String> values) {
            addCriterion("task_method in", values, "taskMethod");
            return (Criteria) this;
        }

        public Criteria andTaskMethodNotIn(List<String> values) {
            addCriterion("task_method not in", values, "taskMethod");
            return (Criteria) this;
        }

        public Criteria andTaskMethodBetween(String value1, String value2) {
            addCriterion("task_method between", value1, value2, "taskMethod");
            return (Criteria) this;
        }

        public Criteria andTaskMethodNotBetween(String value1, String value2) {
            addCriterion("task_method not between", value1, value2, "taskMethod");
            return (Criteria) this;
        }

        public Criteria andTaskCronIsNull() {
            addCriterion("task_cron is null");
            return (Criteria) this;
        }

        public Criteria andTaskCronIsNotNull() {
            addCriterion("task_cron is not null");
            return (Criteria) this;
        }

        public Criteria andTaskCronEqualTo(String value) {
            addCriterion("task_cron =", value, "taskCron");
            return (Criteria) this;
        }

        public Criteria andTaskCronNotEqualTo(String value) {
            addCriterion("task_cron <>", value, "taskCron");
            return (Criteria) this;
        }

        public Criteria andTaskCronGreaterThan(String value) {
            addCriterion("task_cron >", value, "taskCron");
            return (Criteria) this;
        }

        public Criteria andTaskCronGreaterThanOrEqualTo(String value) {
            addCriterion("task_cron >=", value, "taskCron");
            return (Criteria) this;
        }

        public Criteria andTaskCronLessThan(String value) {
            addCriterion("task_cron <", value, "taskCron");
            return (Criteria) this;
        }

        public Criteria andTaskCronLessThanOrEqualTo(String value) {
            addCriterion("task_cron <=", value, "taskCron");
            return (Criteria) this;
        }

        public Criteria andTaskCronLike(String value) {
            addCriterion("task_cron like", value, "taskCron");
            return (Criteria) this;
        }

        public Criteria andTaskCronNotLike(String value) {
            addCriterion("task_cron not like", value, "taskCron");
            return (Criteria) this;
        }

        public Criteria andTaskCronIn(List<String> values) {
            addCriterion("task_cron in", values, "taskCron");
            return (Criteria) this;
        }

        public Criteria andTaskCronNotIn(List<String> values) {
            addCriterion("task_cron not in", values, "taskCron");
            return (Criteria) this;
        }

        public Criteria andTaskCronBetween(String value1, String value2) {
            addCriterion("task_cron between", value1, value2, "taskCron");
            return (Criteria) this;
        }

        public Criteria andTaskCronNotBetween(String value1, String value2) {
            addCriterion("task_cron not between", value1, value2, "taskCron");
            return (Criteria) this;
        }

        public Criteria andTaskDescIsNull() {
            addCriterion("task_desc is null");
            return (Criteria) this;
        }

        public Criteria andTaskDescIsNotNull() {
            addCriterion("task_desc is not null");
            return (Criteria) this;
        }

        public Criteria andTaskDescEqualTo(String value) {
            addCriterion("task_desc =", value, "taskDesc");
            return (Criteria) this;
        }

        public Criteria andTaskDescNotEqualTo(String value) {
            addCriterion("task_desc <>", value, "taskDesc");
            return (Criteria) this;
        }

        public Criteria andTaskDescGreaterThan(String value) {
            addCriterion("task_desc >", value, "taskDesc");
            return (Criteria) this;
        }

        public Criteria andTaskDescGreaterThanOrEqualTo(String value) {
            addCriterion("task_desc >=", value, "taskDesc");
            return (Criteria) this;
        }

        public Criteria andTaskDescLessThan(String value) {
            addCriterion("task_desc <", value, "taskDesc");
            return (Criteria) this;
        }

        public Criteria andTaskDescLessThanOrEqualTo(String value) {
            addCriterion("task_desc <=", value, "taskDesc");
            return (Criteria) this;
        }

        public Criteria andTaskDescLike(String value) {
            addCriterion("task_desc like", value, "taskDesc");
            return (Criteria) this;
        }

        public Criteria andTaskDescNotLike(String value) {
            addCriterion("task_desc not like", value, "taskDesc");
            return (Criteria) this;
        }

        public Criteria andTaskDescIn(List<String> values) {
            addCriterion("task_desc in", values, "taskDesc");
            return (Criteria) this;
        }

        public Criteria andTaskDescNotIn(List<String> values) {
            addCriterion("task_desc not in", values, "taskDesc");
            return (Criteria) this;
        }

        public Criteria andTaskDescBetween(String value1, String value2) {
            addCriterion("task_desc between", value1, value2, "taskDesc");
            return (Criteria) this;
        }

        public Criteria andTaskDescNotBetween(String value1, String value2) {
            addCriterion("task_desc not between", value1, value2, "taskDesc");
            return (Criteria) this;
        }

        public Criteria andTaskStyleIsNull() {
            addCriterion("task_style is null");
            return (Criteria) this;
        }

        public Criteria andTaskStyleIsNotNull() {
            addCriterion("task_style is not null");
            return (Criteria) this;
        }

        public Criteria andTaskStyleEqualTo(Boolean value) {
            addCriterion("task_style =", value, "taskStyle");
            return (Criteria) this;
        }

        public Criteria andTaskStyleNotEqualTo(Boolean value) {
            addCriterion("task_style <>", value, "taskStyle");
            return (Criteria) this;
        }

        public Criteria andTaskStyleGreaterThan(Boolean value) {
            addCriterion("task_style >", value, "taskStyle");
            return (Criteria) this;
        }

        public Criteria andTaskStyleGreaterThanOrEqualTo(Boolean value) {
            addCriterion("task_style >=", value, "taskStyle");
            return (Criteria) this;
        }

        public Criteria andTaskStyleLessThan(Boolean value) {
            addCriterion("task_style <", value, "taskStyle");
            return (Criteria) this;
        }

        public Criteria andTaskStyleLessThanOrEqualTo(Boolean value) {
            addCriterion("task_style <=", value, "taskStyle");
            return (Criteria) this;
        }

        public Criteria andTaskStyleIn(List<Boolean> values) {
            addCriterion("task_style in", values, "taskStyle");
            return (Criteria) this;
        }

        public Criteria andTaskStyleNotIn(List<Boolean> values) {
            addCriterion("task_style not in", values, "taskStyle");
            return (Criteria) this;
        }

        public Criteria andTaskStyleBetween(Boolean value1, Boolean value2) {
            addCriterion("task_style between", value1, value2, "taskStyle");
            return (Criteria) this;
        }

        public Criteria andTaskStyleNotBetween(Boolean value1, Boolean value2) {
            addCriterion("task_style not between", value1, value2, "taskStyle");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNull() {
            addCriterion("created is null");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNotNull() {
            addCriterion("created is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedEqualTo(Date value) {
            addCriterion("created =", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotEqualTo(Date value) {
            addCriterion("created <>", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThan(Date value) {
            addCriterion("created >", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("created >=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThan(Date value) {
            addCriterion("created <", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThanOrEqualTo(Date value) {
            addCriterion("created <=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedIn(List<Date> values) {
            addCriterion("created in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotIn(List<Date> values) {
            addCriterion("created not in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedBetween(Date value1, Date value2) {
            addCriterion("created between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotBetween(Date value1, Date value2) {
            addCriterion("created not between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNull() {
            addCriterion("creator is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("creator is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(String value) {
            addCriterion("creator =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(String value) {
            addCriterion("creator <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(String value) {
            addCriterion("creator >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("creator >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(String value) {
            addCriterion("creator <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(String value) {
            addCriterion("creator <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLike(String value) {
            addCriterion("creator like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotLike(String value) {
            addCriterion("creator not like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<String> values) {
            addCriterion("creator in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<String> values) {
            addCriterion("creator not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(String value1, String value2) {
            addCriterion("creator between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(String value1, String value2) {
            addCriterion("creator not between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andUpdatedIsNull() {
            addCriterion("updated is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedIsNotNull() {
            addCriterion("updated is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedEqualTo(Date value) {
            addCriterion("updated =", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotEqualTo(Date value) {
            addCriterion("updated <>", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThan(Date value) {
            addCriterion("updated >", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThanOrEqualTo(Date value) {
            addCriterion("updated >=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThan(Date value) {
            addCriterion("updated <", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThanOrEqualTo(Date value) {
            addCriterion("updated <=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedIn(List<Date> values) {
            addCriterion("updated in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotIn(List<Date> values) {
            addCriterion("updated not in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedBetween(Date value1, Date value2) {
            addCriterion("updated between", value1, value2, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotBetween(Date value1, Date value2) {
            addCriterion("updated not between", value1, value2, "updated");
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