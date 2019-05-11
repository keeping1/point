package com.example.point.cmcc.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BindingInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public BindingInfoExample() {
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("userid like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("userid not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andAppidIsNull() {
            addCriterion("appid is null");
            return (Criteria) this;
        }

        public Criteria andAppidIsNotNull() {
            addCriterion("appid is not null");
            return (Criteria) this;
        }

        public Criteria andAppidEqualTo(String value) {
            addCriterion("appid =", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotEqualTo(String value) {
            addCriterion("appid <>", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidGreaterThan(String value) {
            addCriterion("appid >", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidGreaterThanOrEqualTo(String value) {
            addCriterion("appid >=", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLessThan(String value) {
            addCriterion("appid <", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLessThanOrEqualTo(String value) {
            addCriterion("appid <=", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLike(String value) {
            addCriterion("appid like", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotLike(String value) {
            addCriterion("appid not like", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidIn(List<String> values) {
            addCriterion("appid in", values, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotIn(List<String> values) {
            addCriterion("appid not in", values, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidBetween(String value1, String value2) {
            addCriterion("appid between", value1, value2, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotBetween(String value1, String value2) {
            addCriterion("appid not between", value1, value2, "appid");
            return (Criteria) this;
        }

        public Criteria andOuterUseridIsNull() {
            addCriterion("outer_userid is null");
            return (Criteria) this;
        }

        public Criteria andOuterUseridIsNotNull() {
            addCriterion("outer_userid is not null");
            return (Criteria) this;
        }

        public Criteria andOuterUseridEqualTo(String value) {
            addCriterion("outer_userid =", value, "outerUserid");
            return (Criteria) this;
        }

        public Criteria andOuterUseridNotEqualTo(String value) {
            addCriterion("outer_userid <>", value, "outerUserid");
            return (Criteria) this;
        }

        public Criteria andOuterUseridGreaterThan(String value) {
            addCriterion("outer_userid >", value, "outerUserid");
            return (Criteria) this;
        }

        public Criteria andOuterUseridGreaterThanOrEqualTo(String value) {
            addCriterion("outer_userid >=", value, "outerUserid");
            return (Criteria) this;
        }

        public Criteria andOuterUseridLessThan(String value) {
            addCriterion("outer_userid <", value, "outerUserid");
            return (Criteria) this;
        }

        public Criteria andOuterUseridLessThanOrEqualTo(String value) {
            addCriterion("outer_userid <=", value, "outerUserid");
            return (Criteria) this;
        }

        public Criteria andOuterUseridLike(String value) {
            addCriterion("outer_userid like", value, "outerUserid");
            return (Criteria) this;
        }

        public Criteria andOuterUseridNotLike(String value) {
            addCriterion("outer_userid not like", value, "outerUserid");
            return (Criteria) this;
        }

        public Criteria andOuterUseridIn(List<String> values) {
            addCriterion("outer_userid in", values, "outerUserid");
            return (Criteria) this;
        }

        public Criteria andOuterUseridNotIn(List<String> values) {
            addCriterion("outer_userid not in", values, "outerUserid");
            return (Criteria) this;
        }

        public Criteria andOuterUseridBetween(String value1, String value2) {
            addCriterion("outer_userid between", value1, value2, "outerUserid");
            return (Criteria) this;
        }

        public Criteria andOuterUseridNotBetween(String value1, String value2) {
            addCriterion("outer_userid not between", value1, value2, "outerUserid");
            return (Criteria) this;
        }

        public Criteria andMobileidIsNull() {
            addCriterion("mobileid is null");
            return (Criteria) this;
        }

        public Criteria andMobileidIsNotNull() {
            addCriterion("mobileid is not null");
            return (Criteria) this;
        }

        public Criteria andMobileidEqualTo(String value) {
            addCriterion("mobileid =", value, "mobileid");
            return (Criteria) this;
        }

        public Criteria andMobileidNotEqualTo(String value) {
            addCriterion("mobileid <>", value, "mobileid");
            return (Criteria) this;
        }

        public Criteria andMobileidGreaterThan(String value) {
            addCriterion("mobileid >", value, "mobileid");
            return (Criteria) this;
        }

        public Criteria andMobileidGreaterThanOrEqualTo(String value) {
            addCriterion("mobileid >=", value, "mobileid");
            return (Criteria) this;
        }

        public Criteria andMobileidLessThan(String value) {
            addCriterion("mobileid <", value, "mobileid");
            return (Criteria) this;
        }

        public Criteria andMobileidLessThanOrEqualTo(String value) {
            addCriterion("mobileid <=", value, "mobileid");
            return (Criteria) this;
        }

        public Criteria andMobileidLike(String value) {
            addCriterion("mobileid like", value, "mobileid");
            return (Criteria) this;
        }

        public Criteria andMobileidNotLike(String value) {
            addCriterion("mobileid not like", value, "mobileid");
            return (Criteria) this;
        }

        public Criteria andMobileidIn(List<String> values) {
            addCriterion("mobileid in", values, "mobileid");
            return (Criteria) this;
        }

        public Criteria andMobileidNotIn(List<String> values) {
            addCriterion("mobileid not in", values, "mobileid");
            return (Criteria) this;
        }

        public Criteria andMobileidBetween(String value1, String value2) {
            addCriterion("mobileid between", value1, value2, "mobileid");
            return (Criteria) this;
        }

        public Criteria andMobileidNotBetween(String value1, String value2) {
            addCriterion("mobileid not between", value1, value2, "mobileid");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("`state` is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("`state` is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("`state` =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("`state` <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("`state` >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("`state` >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("`state` <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("`state` <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("`state` like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("`state` not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("`state` in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("`state` not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("`state` between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("`state` not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andBindingtimesIsNull() {
            addCriterion("bindingtimes is null");
            return (Criteria) this;
        }

        public Criteria andBindingtimesIsNotNull() {
            addCriterion("bindingtimes is not null");
            return (Criteria) this;
        }

        public Criteria andBindingtimesEqualTo(String value) {
            addCriterion("bindingtimes =", value, "bindingtimes");
            return (Criteria) this;
        }

        public Criteria andBindingtimesNotEqualTo(String value) {
            addCriterion("bindingtimes <>", value, "bindingtimes");
            return (Criteria) this;
        }

        public Criteria andBindingtimesGreaterThan(String value) {
            addCriterion("bindingtimes >", value, "bindingtimes");
            return (Criteria) this;
        }

        public Criteria andBindingtimesGreaterThanOrEqualTo(String value) {
            addCriterion("bindingtimes >=", value, "bindingtimes");
            return (Criteria) this;
        }

        public Criteria andBindingtimesLessThan(String value) {
            addCriterion("bindingtimes <", value, "bindingtimes");
            return (Criteria) this;
        }

        public Criteria andBindingtimesLessThanOrEqualTo(String value) {
            addCriterion("bindingtimes <=", value, "bindingtimes");
            return (Criteria) this;
        }

        public Criteria andBindingtimesLike(String value) {
            addCriterion("bindingtimes like", value, "bindingtimes");
            return (Criteria) this;
        }

        public Criteria andBindingtimesNotLike(String value) {
            addCriterion("bindingtimes not like", value, "bindingtimes");
            return (Criteria) this;
        }

        public Criteria andBindingtimesIn(List<String> values) {
            addCriterion("bindingtimes in", values, "bindingtimes");
            return (Criteria) this;
        }

        public Criteria andBindingtimesNotIn(List<String> values) {
            addCriterion("bindingtimes not in", values, "bindingtimes");
            return (Criteria) this;
        }

        public Criteria andBindingtimesBetween(String value1, String value2) {
            addCriterion("bindingtimes between", value1, value2, "bindingtimes");
            return (Criteria) this;
        }

        public Criteria andBindingtimesNotBetween(String value1, String value2) {
            addCriterion("bindingtimes not between", value1, value2, "bindingtimes");
            return (Criteria) this;
        }

        public Criteria andModtimeIsNull() {
            addCriterion("modtime is null");
            return (Criteria) this;
        }

        public Criteria andModtimeIsNotNull() {
            addCriterion("modtime is not null");
            return (Criteria) this;
        }

        public Criteria andModtimeEqualTo(Date value) {
            addCriterionForJDBCDate("modtime =", value, "modtime");
            return (Criteria) this;
        }

        public Criteria andModtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("modtime <>", value, "modtime");
            return (Criteria) this;
        }

        public Criteria andModtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("modtime >", value, "modtime");
            return (Criteria) this;
        }

        public Criteria andModtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("modtime >=", value, "modtime");
            return (Criteria) this;
        }

        public Criteria andModtimeLessThan(Date value) {
            addCriterionForJDBCDate("modtime <", value, "modtime");
            return (Criteria) this;
        }

        public Criteria andModtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("modtime <=", value, "modtime");
            return (Criteria) this;
        }

        public Criteria andModtimeIn(List<Date> values) {
            addCriterionForJDBCDate("modtime in", values, "modtime");
            return (Criteria) this;
        }

        public Criteria andModtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("modtime not in", values, "modtime");
            return (Criteria) this;
        }

        public Criteria andModtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("modtime between", value1, value2, "modtime");
            return (Criteria) this;
        }

        public Criteria andModtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("modtime not between", value1, value2, "modtime");
            return (Criteria) this;
        }

        public Criteria andIntimeIsNull() {
            addCriterion("intime is null");
            return (Criteria) this;
        }

        public Criteria andIntimeIsNotNull() {
            addCriterion("intime is not null");
            return (Criteria) this;
        }

        public Criteria andIntimeEqualTo(Date value) {
            addCriterionForJDBCDate("intime =", value, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("intime <>", value, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeGreaterThan(Date value) {
            addCriterionForJDBCDate("intime >", value, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("intime >=", value, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeLessThan(Date value) {
            addCriterionForJDBCDate("intime <", value, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("intime <=", value, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeIn(List<Date> values) {
            addCriterionForJDBCDate("intime in", values, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("intime not in", values, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("intime between", value1, value2, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("intime not between", value1, value2, "intime");
            return (Criteria) this;
        }
    }

    /**
     */
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