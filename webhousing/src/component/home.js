import React, { useState, useEffect } from 'react';
import { Carousel, Card } from 'react-bootstrap';
import { API_URL, CLOUD_IMG } from "../config/index";
import NumberFormat from "react-number-format";

function Home() {
    const [rooms, setRooms] = useState([]);
    const [cities, setCities] = useState([]);
    const [districts, setDistricts] = useState([]);
    const [wards, setWards] = useState([]);
    const [selectedCity, setSelectedCity] = useState({ id: 0, value: null });
    const [selectedDistrict, setSelectedDistrict] = useState({ id: 0, value: null });
    const [selectedWard, setSelectedWard] = useState({ id: 0, value: null });
    const GHN_TOKEN = 'b08e0769-130e-11ec-b8c6-fade198b4859';

    useEffect(async () => {
        if (rooms) {
            await fetch(API_URL + "room", { method: 'GET' }).then((response) => {
                if (response.ok) {
                    return response.json();
                }
                throw response;
            }).then(data => {
                setRooms(data);
            }).catch((error) => {
                return error;
            });
        }

        getCities();
    }, []);

    const getCities = () => {
        fetch('https://dev-online-gateway.ghn.vn/shiip/public-api/master-data/province'
            , {
                headers: {
                    'Content-Type': 'application/json',
                    'Accept': 'application/json',
                    'token': GHN_TOKEN
                }
            }
        )
            .then(function (response) {
                return response.json();
            })
            .then(function (myJson) {
                if (myJson.data) {
                    setCities(myJson.data);
                }
            });
    };

    const getDistricts = () => {
        fetch(`https://dev-online-gateway.ghn.vn/shiip/public-api/master-data/district`
            , {
                headers: {
                    'Content-Type': 'application/json',
                    'Accept': 'application/json',
                    'token': GHN_TOKEN
                }
            }
        )
            .then(function (response) {
                return response.json();
            })
            .then(function (myJson) {
                var listDistrictByProvince = [];
                myJson.data.map((item) => {
                    if (item.ProvinceID == selectedCity.id) {
                        listDistrictByProvince = [...listDistrictByProvince, item];
                    }
                });
                setDistricts(listDistrictByProvince);
            });
    };

    const getWards = () => {
        console.log(selectedDistrict);
        fetch(`https://dev-online-gateway.ghn.vn/shiip/public-api/master-data/ward?district_id=${selectedDistrict.id}`
            , {
                headers: {
                    'Content-Type': 'application/json',
                    'Accept': 'application/json',
                    'token': GHN_TOKEN
                }
            }
        )
            .then(function (response) {
                return response.json();
            })
            .then(function (myJson) {
                if (myJson.data) {
                    setWards(myJson.data);
                }
            });
    };

    useEffect(() => {
        if (selectedCity) {
            getDistricts();
        }
    }, [selectedCity]);

    useEffect(() => {
        if (selectedDistrict) {
            getWards();
        }
    }, [selectedDistrict]);

    const handleSelectCity = (value) => {
        var valueSplitted = value.split(',');
        setSelectedCity({
            id: valueSplitted[0],
            value: valueSplitted[1]
        });
        setWards([]);
    };

    const handleSelectDistrict = (value) => {
        var valueSplitted = value.split(',');
        setSelectedDistrict({
            id: valueSplitted[0],
            value: valueSplitted[1]
        });
    };

    const handleSelectWard = (value) => {
        var valueSplitted = value.split(',');
        setSelectedWard({
            id: valueSplitted[0],
            value: valueSplitted[1]
        });
    };

    const handleSearchByPlaces = () => {
        const searchData = {
            city: (selectedCity.value) ? selectedCity.value : "",
            district: (selectedDistrict.value) ? selectedDistrict.value : "",
            ward: (selectedWard.value) ? selectedWard.value : "",
        }

        console.log(searchData);

        fetch(`${API_URL}room/search-room`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(searchData),
        })
            .then(response => response.json())
            .then(data => {
                console.log('Success:', data);
                setRooms(data);
            })
            .catch((error) => {
                console.error('Error:', error);
            });
    }

    return (
        <>
            <Carousel className="banner">
                <Carousel.Item>
                    <img
                        className="d-block w-100"
                        src="/banner-1.jpg"
                        alt="First slide"
                    />
                    <Carousel.Caption>
                        <h3 className="text-white">Kênh thông tin Phòng Trọ số 1 Việt Nam</h3>
                        <p>Kênh thông tin Phòng Trọ số 1 Việt Nam - Website đăng tin cho thuê phòng trọ, nhà nguyên căn,
                            căn hộ, ở ghép nhanh, hiệu quả với 100.000+ tin đăng và 2.500.000 lượt xem mỗi tháng.</p>
                    </Carousel.Caption>
                </Carousel.Item>
                <Carousel.Item>
                    <img
                        className="d-block w-100"
                        src="/banner-2.jpg"
                        alt="Second slide"
                    />

                    <Carousel.Caption>
                        <h3 className="text-white">Chi phí thấp, hiệu quả tối đa</h3>
                        <p>Không phải tốn nhiều công sức và chi phí cho việc đăng tin cho thuê: từ việc phát tờ rơi, dán
                            giấy, và đăng lên các website khác nhưng hiệu quả không cao.</p>
                    </Carousel.Caption>
                </Carousel.Item>
                <Carousel.Item>
                    <img
                        className="d-block w-100"
                        src="/banner-3.jpg"
                        alt="Third slide"
                    />

                    <Carousel.Caption>
                        <h3 className="text-white">Bạn đang có phòng trọ / căn hộ cho thuê?</h3>
                        <p>Không phải lo tìm người cho thuê, phòng trống kéo dài</p>
                    </Carousel.Caption>
                </Carousel.Item>
            </Carousel>
            <section className="search-sec">
                <div className="container">
                    <form action="#" method="post" noValidate="novalidate">
                        <div className="row">
                            <div className="col-lg-12">
                                <div className="row">
                                    {/* <div className="col-lg-6 col-12 p-0">
                                        <input type="text" className="form-control search-slt"
                                               placeholder="Tìm kiếm"/>
                                    </div> */}
                                    <div className="col-lg-3 col-12 p-0">
                                        <select className="form-control search-slt" id="province" onChange={(e) => handleSelectCity(e.target.value)}>
                                            <option value="">Chọn tỉnh thành</option>
                                            {
                                                cities.map((item, index) => {
                                                    return <option key={index}
                                                        value={`${item.ProvinceID},${item.ProvinceName}`}>{item.ProvinceName}</option>;
                                                })
                                            }
                                        </select>
                                    </div>
                                    <div className="col-lg-3 col-12 p-0">
                                        <select className="form-control search-slt" id="province" onChange={(e) => handleSelectDistrict(e.target.value)}>
                                            <option value="">Chọn quận huyện</option>
                                            {
                                                districts.map((item, index) => {
                                                    return <option key={index}
                                                        value={`${item.DistrictID},${item.DistrictName}`}>{item.DistrictName}</option>;
                                                })
                                            }
                                        </select>
                                    </div>
                                    <div className="col-lg-3 col-12 p-0">
                                        <select className="form-control search-slt" id="province" onChange={(e) => handleSelectWard(e.target.value)}>
                                            <option value="">Chọn quận huyện</option>
                                            {
                                                wards.map((item, index) => {
                                                    return <option key={index}
                                                        value={`${item.WardCode},${item.WardName}`}>{item.WardName}</option>;
                                                })
                                            }
                                        </select>
                                    </div>
                                    <div className="col-lg-3 col-12 p-0">
                                        <button onClick={(e) => handleSearchByPlaces()} type="button" className="btn bg-gradient btn-danger wrn-btn">Search
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </section>
            <div className="container py-5 w-75">
                <div className="row room-items">
                    {rooms.filter(val => val.status === 1).map((item, i) => {
                        let img = "no-img.png";
                        if (typeof item.image !== 'undefined' && item.image.length) {
                            if (typeof item.image[0].name !== 'undefined') {
                                img = item.image[0].name;
                            }
                        }
                        return (
                            <div key={i} className="col-lg-4 col-12 d-grid justify-content-center pb-5">
                                <Card style={{ width: '18rem' }}>
                                    <Card.Img variant="top"
                                        src={`${CLOUD_IMG}${img}`} />
                                    <Card.Body>
                                        <Card.Title>{item.address && item.address}</Card.Title>
                                        <Card.Text>
                                            {item.addition_infor && item.addition_infor} <br />
                                            Giá: <span className="fw-bold"><NumberFormat value={item.price} displayType={'text'} thousandSeparator={true} /> (VND)</span> <br />
                                            {item.district.name &&
                                                <>
                                                    {item.district.prefix}: {item.district.name} <br />
                                                </>
                                            }
                                            {item.ward.name &&
                                                <>
                                                    {item.ward.prefix}: {item.ward.name} <br />
                                                </>
                                            }
                                            {item.province && item.province.name}
                                        </Card.Text>
                                        <a href={`/room/${item.id}`} className="cs-btn-detail btn btn-default text-white">Chi tiết</a>
                                    </Card.Body>
                                </Card>
                            </div>
                        );
                    })}
                </div>
            </div>
        </>
    )
};

export default Home;