describe('OrderListService', function() {
    beforeEach(module('eventApp.services'));
    
    var OrderListService;

    beforeEach(inject(function(_OrderListService_){
        OrderListService = _OrderListService_;
    }));
    
    describe("should be service",function () {
        it('add ten', function () {
            expect(OrderListService.addToOrder).toBeDefined();
        })
    });
});