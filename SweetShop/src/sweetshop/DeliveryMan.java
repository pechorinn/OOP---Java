package sweetshop;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import client.CorporateClient;
import client.OrdinaryClient;
import client.Voucher;

public class DeliveryMan {

	private String name;
	private String phone;
	private Set<Order> orders;
	private SweetShop myShop;
	private double cash;
	private Random rnd = new Random();

	public DeliveryMan(String name, String phone, SweetShop sweetShop) {
		super();
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.name = name;
		if (phone == null || phone.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.phone = phone;
		this.orders = new HashSet<>();
		if (sweetShop == null ) {
			throw new IllegalArgumentException();
		}
		this.myShop = sweetShop;
		if (!myShop.getDeliveryMan().contains(this)) {
			myShop.getDeliveryMan().add(this);
		}
	}

	@Override
	public String toString() {
		
		String cashString = String.format("%.2f$", cash);
		return "\n-----------------------\nDeliveryMan [name: " + name + ", phone: " + phone + ", orders: " + orders.size() + ", myShop: " + myShop.getName() 
				+ ",\n Total amount of tips: " + cashString + "]\n-----------------------\n";
	}

	public void deliverOrder(Order order) {
		orders.add(order);
		System.out.println("The order with unique number: " + order.getUniqueOrderNumber()
				+ " is delivered at address: " + order.getAddress() + " to client " + order.getClientName());

		settlePayment(order);

	}

	private void settlePayment(Order order) {

		if (order.getClient() instanceof CorporateClient) {
			order.setDiscountAmount((order.getPrice() * ((CorporateClient) order.getClient()).getDiscount() / 100));
			double amountPaidToTheShop = order.getPrice()
					- (order.getPrice() * ((CorporateClient) order.getClient()).getDiscount() / 100);
			double amountOfTip = (order.getPrice() * ((CorporateClient) order.getClient()).getTip() / 100);
			order.getClient().setCash(-amountPaidToTheShop - amountOfTip);
			String amountPaidToTheShopPlusAmountOfTip = String.format("%.2f", (amountPaidToTheShop + amountOfTip));
			System.out.println("Total amount paid by the customer: " + amountPaidToTheShopPlusAmountOfTip + "$");
			myShop.setCash(amountPaidToTheShop);
			String amountPaidToTheShopString = String.format("%.2f", amountPaidToTheShop);
			System.out.println("Amount paid to the shop: " + amountPaidToTheShopString + "$");
			cash += amountOfTip;
			String amountOfTipString = String.format("%.2f", amountOfTip);
			System.out.println("Tip paid to the delivery man: " + amountOfTipString + "$");

		} else if (order.getClient() instanceof OrdinaryClient) {
			
            System.out.println("I'm in ordinary client.");
			Voucher voucher = ((OrdinaryClient) order.getClient()).getVouchers()
					.get(rnd.nextInt(((OrdinaryClient) order.getClient()).getVouchers().size()));
			// no rest is given when using vouchers
			double amountPaidToTheShop = order.getPrice();
			if (voucher != null) {
				String valueOfVoucher = String.format("%.2f", voucher.getValue());
				System.out.println("Voucher is used with value: " + valueOfVoucher);
				order.setDiscountAmount(voucher.getValue());
				amountPaidToTheShop -= voucher.getValue();
				// remove used voucher
				((OrdinaryClient) order.getClient()).getVouchers().remove(voucher);
			}
			double amountOfTip = (order.getPrice() * ((OrdinaryClient) order.getClient()).getTip() / 100);
			if (amountPaidToTheShop <= 0) {
				System.out.println("Voucher covered the cost of the cakes delivered.");
				String amountOfTipString = String.format("%.2f", amountOfTip);
				System.out.println("Only tip is paid: " + amountOfTipString + "$");

			} else {
				String amountPaidToTheShopPlusAmountOfTip = String.format("%.2f", (amountPaidToTheShop + amountOfTip));
				System.out.println("Total amount paid by the customer: " + amountPaidToTheShopPlusAmountOfTip + "$");
				order.getClient().setCash(-amountPaidToTheShop - amountOfTip);
				myShop.setCash(amountPaidToTheShop);
				String amountPaidToTheShopString = String.format("%.2f", amountPaidToTheShop);
				System.out.println("Amount paid to the shop: " + amountPaidToTheShopString + "$");
				cash += amountOfTip;
				String amountOfTipString = String.format("%.2f", amountOfTip);
				System.out.println("Tip paid to the delivery man: " + amountOfTipString + "$");

			}

		}
		order.setStatusHandled();
		System.out.println(order);
	}

	public double getCash() {
		return cash;
	}

	public Set<Order> getOrders() {
		return orders;
	}

}
