package com.microthings.monitor_management.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeviceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeviceExample() {
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

        public Criteria andDeviceIdIsNull() {
            addCriterion("device_id is null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIsNotNull() {
            addCriterion("device_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdEqualTo(Integer value) {
            addCriterion("device_id =", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotEqualTo(Integer value) {
            addCriterion("device_id <>", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThan(Integer value) {
            addCriterion("device_id >", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("device_id >=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThan(Integer value) {
            addCriterion("device_id <", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThanOrEqualTo(Integer value) {
            addCriterion("device_id <=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIn(List<Integer> values) {
            addCriterion("device_id in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotIn(List<Integer> values) {
            addCriterion("device_id not in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdBetween(Integer value1, Integer value2) {
            addCriterion("device_id between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("device_id not between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceNameIsNull() {
            addCriterion("device_name is null");
            return (Criteria) this;
        }

        public Criteria andDeviceNameIsNotNull() {
            addCriterion("device_name is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceNameEqualTo(String value) {
            addCriterion("device_name =", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotEqualTo(String value) {
            addCriterion("device_name <>", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameGreaterThan(String value) {
            addCriterion("device_name >", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameGreaterThanOrEqualTo(String value) {
            addCriterion("device_name >=", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameLessThan(String value) {
            addCriterion("device_name <", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameLessThanOrEqualTo(String value) {
            addCriterion("device_name <=", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameLike(String value) {
            addCriterion("device_name like", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotLike(String value) {
            addCriterion("device_name not like", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameIn(List<String> values) {
            addCriterion("device_name in", values, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotIn(List<String> values) {
            addCriterion("device_name not in", values, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameBetween(String value1, String value2) {
            addCriterion("device_name between", value1, value2, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotBetween(String value1, String value2) {
            addCriterion("device_name not between", value1, value2, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIsNull() {
            addCriterion("device_type is null");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIsNotNull() {
            addCriterion("device_type is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeEqualTo(Long value) {
            addCriterion("device_type =", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotEqualTo(Long value) {
            addCriterion("device_type <>", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeGreaterThan(Long value) {
            addCriterion("device_type >", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeGreaterThanOrEqualTo(Long value) {
            addCriterion("device_type >=", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeLessThan(Long value) {
            addCriterion("device_type <", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeLessThanOrEqualTo(Long value) {
            addCriterion("device_type <=", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIn(List<Long> values) {
            addCriterion("device_type in", values, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotIn(List<Long> values) {
            addCriterion("device_type not in", values, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeBetween(Long value1, Long value2) {
            addCriterion("device_type between", value1, value2, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotBetween(Long value1, Long value2) {
            addCriterion("device_type not between", value1, value2, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceSnIsNull() {
            addCriterion("device_sn is null");
            return (Criteria) this;
        }

        public Criteria andDeviceSnIsNotNull() {
            addCriterion("device_sn is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceSnEqualTo(String value) {
            addCriterion("device_sn =", value, "deviceSn");
            return (Criteria) this;
        }

        public Criteria andDeviceSnNotEqualTo(String value) {
            addCriterion("device_sn <>", value, "deviceSn");
            return (Criteria) this;
        }

        public Criteria andDeviceSnGreaterThan(String value) {
            addCriterion("device_sn >", value, "deviceSn");
            return (Criteria) this;
        }

        public Criteria andDeviceSnGreaterThanOrEqualTo(String value) {
            addCriterion("device_sn >=", value, "deviceSn");
            return (Criteria) this;
        }

        public Criteria andDeviceSnLessThan(String value) {
            addCriterion("device_sn <", value, "deviceSn");
            return (Criteria) this;
        }

        public Criteria andDeviceSnLessThanOrEqualTo(String value) {
            addCriterion("device_sn <=", value, "deviceSn");
            return (Criteria) this;
        }

        public Criteria andDeviceSnLike(String value) {
            addCriterion("device_sn like", value, "deviceSn");
            return (Criteria) this;
        }

        public Criteria andDeviceSnNotLike(String value) {
            addCriterion("device_sn not like", value, "deviceSn");
            return (Criteria) this;
        }

        public Criteria andDeviceSnIn(List<String> values) {
            addCriterion("device_sn in", values, "deviceSn");
            return (Criteria) this;
        }

        public Criteria andDeviceSnNotIn(List<String> values) {
            addCriterion("device_sn not in", values, "deviceSn");
            return (Criteria) this;
        }

        public Criteria andDeviceSnBetween(String value1, String value2) {
            addCriterion("device_sn between", value1, value2, "deviceSn");
            return (Criteria) this;
        }

        public Criteria andDeviceSnNotBetween(String value1, String value2) {
            addCriterion("device_sn not between", value1, value2, "deviceSn");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusIsNull() {
            addCriterion("device_status is null");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusIsNotNull() {
            addCriterion("device_status is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusEqualTo(Long value) {
            addCriterion("device_status =", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusNotEqualTo(Long value) {
            addCriterion("device_status <>", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusGreaterThan(Long value) {
            addCriterion("device_status >", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusGreaterThanOrEqualTo(Long value) {
            addCriterion("device_status >=", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusLessThan(Long value) {
            addCriterion("device_status <", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusLessThanOrEqualTo(Long value) {
            addCriterion("device_status <=", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusIn(List<Long> values) {
            addCriterion("device_status in", values, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusNotIn(List<Long> values) {
            addCriterion("device_status not in", values, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusBetween(Long value1, Long value2) {
            addCriterion("device_status between", value1, value2, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusNotBetween(Long value1, Long value2) {
            addCriterion("device_status not between", value1, value2, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andBuildingIdIsNull() {
            addCriterion("building_id is null");
            return (Criteria) this;
        }

        public Criteria andBuildingIdIsNotNull() {
            addCriterion("building_id is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingIdEqualTo(Integer value) {
            addCriterion("building_id =", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotEqualTo(Integer value) {
            addCriterion("building_id <>", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdGreaterThan(Integer value) {
            addCriterion("building_id >", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("building_id >=", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdLessThan(Integer value) {
            addCriterion("building_id <", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdLessThanOrEqualTo(Integer value) {
            addCriterion("building_id <=", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdIn(List<Integer> values) {
            addCriterion("building_id in", values, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotIn(List<Integer> values) {
            addCriterion("building_id not in", values, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdBetween(Integer value1, Integer value2) {
            addCriterion("building_id between", value1, value2, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotBetween(Integer value1, Integer value2) {
            addCriterion("building_id not between", value1, value2, "buildingId");
            return (Criteria) this;
        }

        public Criteria andDevicePositionIsNull() {
            addCriterion("device_position is null");
            return (Criteria) this;
        }

        public Criteria andDevicePositionIsNotNull() {
            addCriterion("device_position is not null");
            return (Criteria) this;
        }

        public Criteria andDevicePositionEqualTo(String value) {
            addCriterion("device_position =", value, "devicePosition");
            return (Criteria) this;
        }

        public Criteria andDevicePositionNotEqualTo(String value) {
            addCriterion("device_position <>", value, "devicePosition");
            return (Criteria) this;
        }

        public Criteria andDevicePositionGreaterThan(String value) {
            addCriterion("device_position >", value, "devicePosition");
            return (Criteria) this;
        }

        public Criteria andDevicePositionGreaterThanOrEqualTo(String value) {
            addCriterion("device_position >=", value, "devicePosition");
            return (Criteria) this;
        }

        public Criteria andDevicePositionLessThan(String value) {
            addCriterion("device_position <", value, "devicePosition");
            return (Criteria) this;
        }

        public Criteria andDevicePositionLessThanOrEqualTo(String value) {
            addCriterion("device_position <=", value, "devicePosition");
            return (Criteria) this;
        }

        public Criteria andDevicePositionLike(String value) {
            addCriterion("device_position like", value, "devicePosition");
            return (Criteria) this;
        }

        public Criteria andDevicePositionNotLike(String value) {
            addCriterion("device_position not like", value, "devicePosition");
            return (Criteria) this;
        }

        public Criteria andDevicePositionIn(List<String> values) {
            addCriterion("device_position in", values, "devicePosition");
            return (Criteria) this;
        }

        public Criteria andDevicePositionNotIn(List<String> values) {
            addCriterion("device_position not in", values, "devicePosition");
            return (Criteria) this;
        }

        public Criteria andDevicePositionBetween(String value1, String value2) {
            addCriterion("device_position between", value1, value2, "devicePosition");
            return (Criteria) this;
        }

        public Criteria andDevicePositionNotBetween(String value1, String value2) {
            addCriterion("device_position not between", value1, value2, "devicePosition");
            return (Criteria) this;
        }

        public Criteria andDeviceFloorIsNull() {
            addCriterion("device_floor is null");
            return (Criteria) this;
        }

        public Criteria andDeviceFloorIsNotNull() {
            addCriterion("device_floor is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceFloorEqualTo(Long value) {
            addCriterion("device_floor =", value, "deviceFloor");
            return (Criteria) this;
        }

        public Criteria andDeviceFloorNotEqualTo(Long value) {
            addCriterion("device_floor <>", value, "deviceFloor");
            return (Criteria) this;
        }

        public Criteria andDeviceFloorGreaterThan(Long value) {
            addCriterion("device_floor >", value, "deviceFloor");
            return (Criteria) this;
        }

        public Criteria andDeviceFloorGreaterThanOrEqualTo(Long value) {
            addCriterion("device_floor >=", value, "deviceFloor");
            return (Criteria) this;
        }

        public Criteria andDeviceFloorLessThan(Long value) {
            addCriterion("device_floor <", value, "deviceFloor");
            return (Criteria) this;
        }

        public Criteria andDeviceFloorLessThanOrEqualTo(Long value) {
            addCriterion("device_floor <=", value, "deviceFloor");
            return (Criteria) this;
        }

        public Criteria andDeviceFloorIn(List<Long> values) {
            addCriterion("device_floor in", values, "deviceFloor");
            return (Criteria) this;
        }

        public Criteria andDeviceFloorNotIn(List<Long> values) {
            addCriterion("device_floor not in", values, "deviceFloor");
            return (Criteria) this;
        }

        public Criteria andDeviceFloorBetween(Long value1, Long value2) {
            addCriterion("device_floor between", value1, value2, "deviceFloor");
            return (Criteria) this;
        }

        public Criteria andDeviceFloorNotBetween(Long value1, Long value2) {
            addCriterion("device_floor not between", value1, value2, "deviceFloor");
            return (Criteria) this;
        }

        public Criteria andDeviceScalingIsNull() {
            addCriterion("device_scaling is null");
            return (Criteria) this;
        }

        public Criteria andDeviceScalingIsNotNull() {
            addCriterion("device_scaling is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceScalingEqualTo(Double value) {
            addCriterion("device_scaling =", value, "deviceScaling");
            return (Criteria) this;
        }

        public Criteria andDeviceScalingNotEqualTo(Double value) {
            addCriterion("device_scaling <>", value, "deviceScaling");
            return (Criteria) this;
        }

        public Criteria andDeviceScalingGreaterThan(Double value) {
            addCriterion("device_scaling >", value, "deviceScaling");
            return (Criteria) this;
        }

        public Criteria andDeviceScalingGreaterThanOrEqualTo(Double value) {
            addCriterion("device_scaling >=", value, "deviceScaling");
            return (Criteria) this;
        }

        public Criteria andDeviceScalingLessThan(Double value) {
            addCriterion("device_scaling <", value, "deviceScaling");
            return (Criteria) this;
        }

        public Criteria andDeviceScalingLessThanOrEqualTo(Double value) {
            addCriterion("device_scaling <=", value, "deviceScaling");
            return (Criteria) this;
        }

        public Criteria andDeviceScalingIn(List<Double> values) {
            addCriterion("device_scaling in", values, "deviceScaling");
            return (Criteria) this;
        }

        public Criteria andDeviceScalingNotIn(List<Double> values) {
            addCriterion("device_scaling not in", values, "deviceScaling");
            return (Criteria) this;
        }

        public Criteria andDeviceScalingBetween(Double value1, Double value2) {
            addCriterion("device_scaling between", value1, value2, "deviceScaling");
            return (Criteria) this;
        }

        public Criteria andDeviceScalingNotBetween(Double value1, Double value2) {
            addCriterion("device_scaling not between", value1, value2, "deviceScaling");
            return (Criteria) this;
        }

        public Criteria andDeviceAngleIsNull() {
            addCriterion("device_angle is null");
            return (Criteria) this;
        }

        public Criteria andDeviceAngleIsNotNull() {
            addCriterion("device_angle is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceAngleEqualTo(Double value) {
            addCriterion("device_angle =", value, "deviceAngle");
            return (Criteria) this;
        }

        public Criteria andDeviceAngleNotEqualTo(Double value) {
            addCriterion("device_angle <>", value, "deviceAngle");
            return (Criteria) this;
        }

        public Criteria andDeviceAngleGreaterThan(Double value) {
            addCriterion("device_angle >", value, "deviceAngle");
            return (Criteria) this;
        }

        public Criteria andDeviceAngleGreaterThanOrEqualTo(Double value) {
            addCriterion("device_angle >=", value, "deviceAngle");
            return (Criteria) this;
        }

        public Criteria andDeviceAngleLessThan(Double value) {
            addCriterion("device_angle <", value, "deviceAngle");
            return (Criteria) this;
        }

        public Criteria andDeviceAngleLessThanOrEqualTo(Double value) {
            addCriterion("device_angle <=", value, "deviceAngle");
            return (Criteria) this;
        }

        public Criteria andDeviceAngleIn(List<Double> values) {
            addCriterion("device_angle in", values, "deviceAngle");
            return (Criteria) this;
        }

        public Criteria andDeviceAngleNotIn(List<Double> values) {
            addCriterion("device_angle not in", values, "deviceAngle");
            return (Criteria) this;
        }

        public Criteria andDeviceAngleBetween(Double value1, Double value2) {
            addCriterion("device_angle between", value1, value2, "deviceAngle");
            return (Criteria) this;
        }

        public Criteria andDeviceAngleNotBetween(Double value1, Double value2) {
            addCriterion("device_angle not between", value1, value2, "deviceAngle");
            return (Criteria) this;
        }

        public Criteria andMapPositionXIsNull() {
            addCriterion("map_position_x is null");
            return (Criteria) this;
        }

        public Criteria andMapPositionXIsNotNull() {
            addCriterion("map_position_x is not null");
            return (Criteria) this;
        }

        public Criteria andMapPositionXEqualTo(Double value) {
            addCriterion("map_position_x =", value, "mapPositionX");
            return (Criteria) this;
        }

        public Criteria andMapPositionXNotEqualTo(Double value) {
            addCriterion("map_position_x <>", value, "mapPositionX");
            return (Criteria) this;
        }

        public Criteria andMapPositionXGreaterThan(Double value) {
            addCriterion("map_position_x >", value, "mapPositionX");
            return (Criteria) this;
        }

        public Criteria andMapPositionXGreaterThanOrEqualTo(Double value) {
            addCriterion("map_position_x >=", value, "mapPositionX");
            return (Criteria) this;
        }

        public Criteria andMapPositionXLessThan(Double value) {
            addCriterion("map_position_x <", value, "mapPositionX");
            return (Criteria) this;
        }

        public Criteria andMapPositionXLessThanOrEqualTo(Double value) {
            addCriterion("map_position_x <=", value, "mapPositionX");
            return (Criteria) this;
        }

        public Criteria andMapPositionXIn(List<Double> values) {
            addCriterion("map_position_x in", values, "mapPositionX");
            return (Criteria) this;
        }

        public Criteria andMapPositionXNotIn(List<Double> values) {
            addCriterion("map_position_x not in", values, "mapPositionX");
            return (Criteria) this;
        }

        public Criteria andMapPositionXBetween(Double value1, Double value2) {
            addCriterion("map_position_x between", value1, value2, "mapPositionX");
            return (Criteria) this;
        }

        public Criteria andMapPositionXNotBetween(Double value1, Double value2) {
            addCriterion("map_position_x not between", value1, value2, "mapPositionX");
            return (Criteria) this;
        }

        public Criteria andMapPositionYIsNull() {
            addCriterion("map_position_y is null");
            return (Criteria) this;
        }

        public Criteria andMapPositionYIsNotNull() {
            addCriterion("map_position_y is not null");
            return (Criteria) this;
        }

        public Criteria andMapPositionYEqualTo(Double value) {
            addCriterion("map_position_y =", value, "mapPositionY");
            return (Criteria) this;
        }

        public Criteria andMapPositionYNotEqualTo(Double value) {
            addCriterion("map_position_y <>", value, "mapPositionY");
            return (Criteria) this;
        }

        public Criteria andMapPositionYGreaterThan(Double value) {
            addCriterion("map_position_y >", value, "mapPositionY");
            return (Criteria) this;
        }

        public Criteria andMapPositionYGreaterThanOrEqualTo(Double value) {
            addCriterion("map_position_y >=", value, "mapPositionY");
            return (Criteria) this;
        }

        public Criteria andMapPositionYLessThan(Double value) {
            addCriterion("map_position_y <", value, "mapPositionY");
            return (Criteria) this;
        }

        public Criteria andMapPositionYLessThanOrEqualTo(Double value) {
            addCriterion("map_position_y <=", value, "mapPositionY");
            return (Criteria) this;
        }

        public Criteria andMapPositionYIn(List<Double> values) {
            addCriterion("map_position_y in", values, "mapPositionY");
            return (Criteria) this;
        }

        public Criteria andMapPositionYNotIn(List<Double> values) {
            addCriterion("map_position_y not in", values, "mapPositionY");
            return (Criteria) this;
        }

        public Criteria andMapPositionYBetween(Double value1, Double value2) {
            addCriterion("map_position_y between", value1, value2, "mapPositionY");
            return (Criteria) this;
        }

        public Criteria andMapPositionYNotBetween(Double value1, Double value2) {
            addCriterion("map_position_y not between", value1, value2, "mapPositionY");
            return (Criteria) this;
        }

        public Criteria andMonitorAheadIsNull() {
            addCriterion("monitor_ahead is null");
            return (Criteria) this;
        }

        public Criteria andMonitorAheadIsNotNull() {
            addCriterion("monitor_ahead is not null");
            return (Criteria) this;
        }

        public Criteria andMonitorAheadEqualTo(Double value) {
            addCriterion("monitor_ahead =", value, "monitorAhead");
            return (Criteria) this;
        }

        public Criteria andMonitorAheadNotEqualTo(Double value) {
            addCriterion("monitor_ahead <>", value, "monitorAhead");
            return (Criteria) this;
        }

        public Criteria andMonitorAheadGreaterThan(Double value) {
            addCriterion("monitor_ahead >", value, "monitorAhead");
            return (Criteria) this;
        }

        public Criteria andMonitorAheadGreaterThanOrEqualTo(Double value) {
            addCriterion("monitor_ahead >=", value, "monitorAhead");
            return (Criteria) this;
        }

        public Criteria andMonitorAheadLessThan(Double value) {
            addCriterion("monitor_ahead <", value, "monitorAhead");
            return (Criteria) this;
        }

        public Criteria andMonitorAheadLessThanOrEqualTo(Double value) {
            addCriterion("monitor_ahead <=", value, "monitorAhead");
            return (Criteria) this;
        }

        public Criteria andMonitorAheadIn(List<Double> values) {
            addCriterion("monitor_ahead in", values, "monitorAhead");
            return (Criteria) this;
        }

        public Criteria andMonitorAheadNotIn(List<Double> values) {
            addCriterion("monitor_ahead not in", values, "monitorAhead");
            return (Criteria) this;
        }

        public Criteria andMonitorAheadBetween(Double value1, Double value2) {
            addCriterion("monitor_ahead between", value1, value2, "monitorAhead");
            return (Criteria) this;
        }

        public Criteria andMonitorAheadNotBetween(Double value1, Double value2) {
            addCriterion("monitor_ahead not between", value1, value2, "monitorAhead");
            return (Criteria) this;
        }

        public Criteria andMonitorLeftIsNull() {
            addCriterion("monitor_left is null");
            return (Criteria) this;
        }

        public Criteria andMonitorLeftIsNotNull() {
            addCriterion("monitor_left is not null");
            return (Criteria) this;
        }

        public Criteria andMonitorLeftEqualTo(Double value) {
            addCriterion("monitor_left =", value, "monitorLeft");
            return (Criteria) this;
        }

        public Criteria andMonitorLeftNotEqualTo(Double value) {
            addCriterion("monitor_left <>", value, "monitorLeft");
            return (Criteria) this;
        }

        public Criteria andMonitorLeftGreaterThan(Double value) {
            addCriterion("monitor_left >", value, "monitorLeft");
            return (Criteria) this;
        }

        public Criteria andMonitorLeftGreaterThanOrEqualTo(Double value) {
            addCriterion("monitor_left >=", value, "monitorLeft");
            return (Criteria) this;
        }

        public Criteria andMonitorLeftLessThan(Double value) {
            addCriterion("monitor_left <", value, "monitorLeft");
            return (Criteria) this;
        }

        public Criteria andMonitorLeftLessThanOrEqualTo(Double value) {
            addCriterion("monitor_left <=", value, "monitorLeft");
            return (Criteria) this;
        }

        public Criteria andMonitorLeftIn(List<Double> values) {
            addCriterion("monitor_left in", values, "monitorLeft");
            return (Criteria) this;
        }

        public Criteria andMonitorLeftNotIn(List<Double> values) {
            addCriterion("monitor_left not in", values, "monitorLeft");
            return (Criteria) this;
        }

        public Criteria andMonitorLeftBetween(Double value1, Double value2) {
            addCriterion("monitor_left between", value1, value2, "monitorLeft");
            return (Criteria) this;
        }

        public Criteria andMonitorLeftNotBetween(Double value1, Double value2) {
            addCriterion("monitor_left not between", value1, value2, "monitorLeft");
            return (Criteria) this;
        }

        public Criteria andMonitorRightIsNull() {
            addCriterion("monitor_right is null");
            return (Criteria) this;
        }

        public Criteria andMonitorRightIsNotNull() {
            addCriterion("monitor_right is not null");
            return (Criteria) this;
        }

        public Criteria andMonitorRightEqualTo(Double value) {
            addCriterion("monitor_right =", value, "monitorRight");
            return (Criteria) this;
        }

        public Criteria andMonitorRightNotEqualTo(Double value) {
            addCriterion("monitor_right <>", value, "monitorRight");
            return (Criteria) this;
        }

        public Criteria andMonitorRightGreaterThan(Double value) {
            addCriterion("monitor_right >", value, "monitorRight");
            return (Criteria) this;
        }

        public Criteria andMonitorRightGreaterThanOrEqualTo(Double value) {
            addCriterion("monitor_right >=", value, "monitorRight");
            return (Criteria) this;
        }

        public Criteria andMonitorRightLessThan(Double value) {
            addCriterion("monitor_right <", value, "monitorRight");
            return (Criteria) this;
        }

        public Criteria andMonitorRightLessThanOrEqualTo(Double value) {
            addCriterion("monitor_right <=", value, "monitorRight");
            return (Criteria) this;
        }

        public Criteria andMonitorRightIn(List<Double> values) {
            addCriterion("monitor_right in", values, "monitorRight");
            return (Criteria) this;
        }

        public Criteria andMonitorRightNotIn(List<Double> values) {
            addCriterion("monitor_right not in", values, "monitorRight");
            return (Criteria) this;
        }

        public Criteria andMonitorRightBetween(Double value1, Double value2) {
            addCriterion("monitor_right between", value1, value2, "monitorRight");
            return (Criteria) this;
        }

        public Criteria andMonitorRightNotBetween(Double value1, Double value2) {
            addCriterion("monitor_right not between", value1, value2, "monitorRight");
            return (Criteria) this;
        }

        public Criteria andIpIsNull() {
            addCriterion("ip is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("ip is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("ip =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("ip <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("ip >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("ip >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("ip <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("ip <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("ip like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("ip not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("ip in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("ip not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("ip between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("ip not between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andPortIsNull() {
            addCriterion("port is null");
            return (Criteria) this;
        }

        public Criteria andPortIsNotNull() {
            addCriterion("port is not null");
            return (Criteria) this;
        }

        public Criteria andPortEqualTo(String value) {
            addCriterion("port =", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotEqualTo(String value) {
            addCriterion("port <>", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortGreaterThan(String value) {
            addCriterion("port >", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortGreaterThanOrEqualTo(String value) {
            addCriterion("port >=", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLessThan(String value) {
            addCriterion("port <", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLessThanOrEqualTo(String value) {
            addCriterion("port <=", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLike(String value) {
            addCriterion("port like", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotLike(String value) {
            addCriterion("port not like", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortIn(List<String> values) {
            addCriterion("port in", values, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotIn(List<String> values) {
            addCriterion("port not in", values, "port");
            return (Criteria) this;
        }

        public Criteria andPortBetween(String value1, String value2) {
            addCriterion("port between", value1, value2, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotBetween(String value1, String value2) {
            addCriterion("port not between", value1, value2, "port");
            return (Criteria) this;
        }

        public Criteria andAssociationMmwaveSnIsNull() {
            addCriterion("association_mmwave_sn is null");
            return (Criteria) this;
        }

        public Criteria andAssociationMmwaveSnIsNotNull() {
            addCriterion("association_mmwave_sn is not null");
            return (Criteria) this;
        }

        public Criteria andAssociationMmwaveSnEqualTo(String value) {
            addCriterion("association_mmwave_sn =", value, "associationMmwaveSn");
            return (Criteria) this;
        }

        public Criteria andAssociationMmwaveSnNotEqualTo(String value) {
            addCriterion("association_mmwave_sn <>", value, "associationMmwaveSn");
            return (Criteria) this;
        }

        public Criteria andAssociationMmwaveSnGreaterThan(String value) {
            addCriterion("association_mmwave_sn >", value, "associationMmwaveSn");
            return (Criteria) this;
        }

        public Criteria andAssociationMmwaveSnGreaterThanOrEqualTo(String value) {
            addCriterion("association_mmwave_sn >=", value, "associationMmwaveSn");
            return (Criteria) this;
        }

        public Criteria andAssociationMmwaveSnLessThan(String value) {
            addCriterion("association_mmwave_sn <", value, "associationMmwaveSn");
            return (Criteria) this;
        }

        public Criteria andAssociationMmwaveSnLessThanOrEqualTo(String value) {
            addCriterion("association_mmwave_sn <=", value, "associationMmwaveSn");
            return (Criteria) this;
        }

        public Criteria andAssociationMmwaveSnLike(String value) {
            addCriterion("association_mmwave_sn like", value, "associationMmwaveSn");
            return (Criteria) this;
        }

        public Criteria andAssociationMmwaveSnNotLike(String value) {
            addCriterion("association_mmwave_sn not like", value, "associationMmwaveSn");
            return (Criteria) this;
        }

        public Criteria andAssociationMmwaveSnIn(List<String> values) {
            addCriterion("association_mmwave_sn in", values, "associationMmwaveSn");
            return (Criteria) this;
        }

        public Criteria andAssociationMmwaveSnNotIn(List<String> values) {
            addCriterion("association_mmwave_sn not in", values, "associationMmwaveSn");
            return (Criteria) this;
        }

        public Criteria andAssociationMmwaveSnBetween(String value1, String value2) {
            addCriterion("association_mmwave_sn between", value1, value2, "associationMmwaveSn");
            return (Criteria) this;
        }

        public Criteria andAssociationMmwaveSnNotBetween(String value1, String value2) {
            addCriterion("association_mmwave_sn not between", value1, value2, "associationMmwaveSn");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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